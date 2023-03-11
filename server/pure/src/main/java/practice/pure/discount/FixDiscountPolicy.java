package practice.pure.discount;

import practice.pure.member.Grade;
import practice.pure.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;
    @Override
    public int discount(Grade memberGrade, int price) {
        if (memberGrade == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
