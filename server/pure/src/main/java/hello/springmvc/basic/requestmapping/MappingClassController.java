package hello.springmvc.basic.requestmapping;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
@Slf4j
public class MappingClassController {
    @GetMapping
    public String getUsers() {
        log.info("getUsers");
        return "ok";
    }

    @PostMapping
    public String createUser() {
        log.info("createUser");
        return "ok";
    }

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable Long userId) {
        return "Get " + userId + " number user";
    }

    @PatchMapping("/{userId}")
    public String putUserById(@PathVariable Long userId) {
        return "Changed " + userId + " number user";
    }

    @DeleteMapping("/{userId}")
    public String deleteUserById(@PathVariable Long userId) {
        return "Deleted " + userId + " number user";
    }
}
