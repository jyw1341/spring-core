package jyw.core.discount;

import jyw.core.member.Grade;
import jyw.core.member.Member;

public class FixeDiscountPolicy implements DiscountPolicy{

    private int discountFixedAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return discountFixedAmount;
        else
            return 0;
    }
}
