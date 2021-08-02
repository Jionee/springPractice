package hello.core.member;

import hello.core.AppConfig;

public class MemberApp {
    public static void main(String[] args){
        //MemberService memberService = new MemberServiceImpl();
        //AppConfig를 사용하여 memberService 생성
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("new Member = " + member.getName());
    }
}
