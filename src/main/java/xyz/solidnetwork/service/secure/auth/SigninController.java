package xyz.solidnetwork.service.secure.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SigninController {
    @PostMapping("/auth/signin")
    public Signin signin() {
        log.info("signin is requested");
        return new Signin();
    }
}
