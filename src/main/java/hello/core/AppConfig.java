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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스(IoC컨테이너 또는 DI 컨테이너라고 부름)
생성자를 통해 주입
MemberServiceImpl -> MemoryMemberRepository
OrderServiceImpl -> MemoryMemberRepository , FixDiscountPolicy
*/
@Configuration
public class AppConfig {

    //MemberServiceImpl가 호출하는 메소드
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository());
    }

    //구현 객체 주입
    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    //OrderServiceImpl가 호출하는 메소드
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), getDiscountPolicy());
    }

    //구현 객체 주입
    @Bean
    public DiscountPolicy getDiscountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
