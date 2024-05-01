package xyz.solidnetwork.service.secure;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProfileController {

    @PostMapping("/profile")
    public Profile getProfile() {
        log.info("profile is requested");
        return new Profile();
    }

}
