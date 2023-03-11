package practice.pure.discount;

import practice.pure.member.Grade;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
    */
    int discount(Grade memberGrade, int price);
}
