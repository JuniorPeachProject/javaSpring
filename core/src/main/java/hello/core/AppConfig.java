package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;


public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memeberRepository());
    }

    private static MemoryMemberRepository memeberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memeberRepository(), discountPolicy());
    }

    private static FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
