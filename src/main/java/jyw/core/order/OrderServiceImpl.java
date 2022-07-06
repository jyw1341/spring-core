package jyw.core.order;

import jyw.core.discount.DiscountPolicy;
import jyw.core.discount.FixeDiscountPolicy;
import jyw.core.member.Member;
import jyw.core.member.MemberRepository;
import jyw.core.member.MemoryMemberRepository;

/**
 * SRP 원칙이 잘 지켜진 예이다.
 * 오더와 할인의 역할 분담이 잘 이루어져있다.
 * 할인이 변경되면 discountPolicy 만 변경하면 된다.
 */

public class OrderServiceImpl implements OrderService{
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
