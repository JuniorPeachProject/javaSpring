package wad.test.api.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wad.test.api.controller.order.request.OrderCreateRequest;
import wad.test.api.controller.order.response.OrderResponse;
import wad.test.domain.order.Order;
import wad.test.domain.order.OrderRepository;
import wad.test.domain.product.Product;
import wad.test.domain.product.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.getProductNumbers();
        // Product
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);
        Order order = Order.create(products, registeredDateTime);
        // Order
        Order savedOrder = orderRepository.save(order);
        return OrderResponse.of(savedOrder);
    }
}
