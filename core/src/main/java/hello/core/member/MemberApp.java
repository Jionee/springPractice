package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args){
        //MemberService memberService = new MemberServiceImpl();
        //AppConfig를 사용하여 memberService 생성

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //spring으로 사용하기
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("new Member = " + member.getName());
    }
}
