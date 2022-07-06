package jyw.core;

import jyw.core.discount.DiscountPolicy;
import jyw.core.discount.FixeDiscountPolicy;
import jyw.core.discount.RateDiscountPolicy;
import jyw.core.member.MemberRepository;
import jyw.core.member.MemberService;
import jyw.core.member.MemberServiceImpl;
import jyw.core.member.MemoryMemberRepository;
import jyw.core.order.OrderService;
import jyw.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
