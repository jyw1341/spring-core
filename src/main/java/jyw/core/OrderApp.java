package jyw.core;

import jyw.core.member.Grade;
import jyw.core.member.Member;
import jyw.core.member.MemberService;
import jyw.core.member.MemberServiceImpl;
import jyw.core.order.Order;
import jyw.core.order.OrderService;
import jyw.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig config = new AppConfig();
//        MemberService memberService = config.memberService();
//        OrderService orderService = config.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order" + itemA.toString());
    }
}
