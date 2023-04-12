package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {
    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        //
        // log.debug(" debug log=" + name);
        // 똑같아 보이지만 + 연산은 평가 후에 호출을 할지 말지 결정하기 때문에 좋지 않다.
        log.debug(" debug log={}", name);

        return "ok";
    }
}
