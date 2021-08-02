package hello.core.order;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
//import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements  OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //의존관계 위반(OCP 위반)

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //-> 구현체에 의존하지 않고 interface에만 의존한다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원 조회
        int discountPrice = discountPolicy.discount(member,itemPrice); //단일 책임 원칙. 주문에서 할인은 잘 모르겠어 discountPolicy너가 알아서 해줘

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
