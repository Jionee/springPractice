package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//공연 기획자의 역할
//생성자 주입
public class AppConfig {
    //역할
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    //역할
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //객체
    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    //객체
    private FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
