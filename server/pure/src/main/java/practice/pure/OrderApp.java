package practice.pure;

import practice.pure.member.Grade;
import practice.pure.member.Member;
import practice.pure.member.MemberService;
import practice.pure.member.MemberServiceImpl;
import practice.pure.order.Order;
import practice.pure.order.OrderService;
import practice.pure.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("final price = " + order.calculatePrice());
    }
}
