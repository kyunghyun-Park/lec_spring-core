package hello.core;

import hello.core.member.*;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //BEFORE
        //MemberService memberService  = new MemberServiceImpl(new MemoryMemberRepository());\

        //AFTER
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService  = appConfig.memberService();*/

        //스프링 컨테이너 사용
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}
