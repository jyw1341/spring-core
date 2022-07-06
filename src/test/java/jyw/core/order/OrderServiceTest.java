package jyw.core.order;

import jyw.core.AppConfig;
import jyw.core.member.Grade;
import jyw.core.member.Member;
import jyw.core.member.MemberService;
import jyw.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {


    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig config = new AppConfig();
        memberService = config.memberService();
        orderService = config.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(itemA.getItemPrice() - itemA.getDiscountPrice()).isEqualTo(itemA.calculatedPrice());
    }
}