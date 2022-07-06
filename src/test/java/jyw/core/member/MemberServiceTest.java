package jyw.core.member;

import jyw.core.AppConfig;
import jyw.core.order.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig config = new AppConfig();
        memberService = config.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findMember() {
    }
}