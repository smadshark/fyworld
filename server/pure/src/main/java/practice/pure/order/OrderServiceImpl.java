package practice.pure.order;

import practice.pure.discount.DiscountPolicy;
import practice.pure.discount.FixDiscountPolicy;
import practice.pure.member.Member;
import practice.pure.member.MemberRepository;
import practice.pure.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member.getGrade(), itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
