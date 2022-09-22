package hello.core;

import hello.core.discount.FixDiscountPolicy;
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

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
