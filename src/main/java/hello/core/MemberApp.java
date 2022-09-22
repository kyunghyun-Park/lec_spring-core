package hello.core;

import hello.core.member.*;

public class MemberApp {

    public static void main(String[] args) {
        //BEFORE
        //MemberService memberService  = new MemberServiceImpl(new MemoryMemberRepository());\

        //AFTER
        AppConfig appConfig = new AppConfig();
        MemberService memberService  = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}
