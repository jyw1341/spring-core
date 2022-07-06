package jyw.core;

import jyw.core.member.Grade;
import jyw.core.member.Member;
import jyw.core.member.MemberService;
import jyw.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 순수 자발 개발
 * 이렇게 하지말고 Junit 을 사용하자..
 */

public class MemberApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
//        AppConfig config = new AppConfig();
//        MemberService memberService = config.memberService();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + memberA.getName());
        System.out.println("find member = "+ findMember.getName());
    }
}
