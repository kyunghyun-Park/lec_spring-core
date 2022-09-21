package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //after(인터페이스에만 의존하도록)
    private DiscountPolicy discountPolicy;
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //discountPolicy가 없었다면 할인에대한 변경을 이 곳에서 바꿔야할 수도 있었음.(단일체계원칙 잘 지켜진 것)
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
