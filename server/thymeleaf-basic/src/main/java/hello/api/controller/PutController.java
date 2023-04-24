package hello.api.controller;

import hello.api.dto.MemberDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PutMapping("/member")
    public String putMember(@RequestBody Map<String, Object> putData) {
        System.out.println("PutController.putMember");
        StringBuilder sb = new StringBuilder();
        putData.forEach((key, value) -> sb.append(key).append(":").append(value).append("\n"));

        return sb.toString();
    }

    @PutMapping("/member1")
    public String putMember1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PutMapping("/member2")
    public MemberDto putMember2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }
}
