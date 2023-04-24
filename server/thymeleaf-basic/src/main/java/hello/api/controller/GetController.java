package hello.api.controller;

import hello.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    @GetMapping("/name")
    public String getName() {
        return "Son";
    }

    @GetMapping("/variable1/{variable}")
    public String getVariable(@PathVariable String variable) {
        return "hello " + variable;
    }

    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable(name = "variable") String unMatched) {
        return "hello " + unMatched;
    }

    @GetMapping("/qstest1")
    public String getQs1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        return "name: " + name + "<br>email: " + email + "<br>organization: " + organization;
    }

    @GetMapping("/request2")
    public String getRequest2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.forEach((key, value) -> sb.append(key).append(":").append(value).append("\n"));

        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequest3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
