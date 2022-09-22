package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
// 생성자를 통해 주입
/*
MemberServiceImpl -> MemoryMemberRepository
OrderServiceImpl -> MemoryMemberRepository , FixDiscountPolicy
*/
public class AppConfig {

    //MemberServiceImpl가 호출하는 메소드
    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    //구현 객체 주입
    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    //OrderServiceImpl가 호출하는 메소드
    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    //구현 객체 주입
    private DiscountPolicy getDiscountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
