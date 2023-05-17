package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired EntityManager em;
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    @Test
    public void 상품주문() {
        Member member = getMember("서울", "개운사길", "123-132");

        Book book = getBook("시골 JPA", 10000, 10);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        Order one = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, one.getStatus());
        assertEquals(1, one.getOrderItems().size());
        assertEquals(10000*orderCount, one.getTotalPrice());
        assertEquals(8, book.getStockQuantity());
    }

    private Book getBook(String name, int price, int q) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(q);
        em.persist(book);
        return book;
    }

    private Member getMember(String city, String street, String zipcode) {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address(city, street, zipcode));
        em.persist(member);
        return member;
    }

    @Test
    public void 주문취소() {
        Member member = getMember("서울", "개운사길", "123-132");
        Book book = getBook("시골 JPA", 10000, 10);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        orderService.cancelOrder(orderId);

        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CALCEL, getOrder.getStatus());
        assertEquals(10, book.getStockQuantity());
    }

    @Test
    public void 상품주문_재고수량초과() {
        Member member = getMember("서울", "개운사길", "123-132");
        Book book = getBook("시골 JPA", 10000, 10);

        int orderCount = 11;

        Assertions.assertThrows(NotEnoughStockException.class,
                ()->orderService.order(member.getId(), book.getId(), orderCount));
    }
}