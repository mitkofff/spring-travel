package com.tu.travel.web;

import com.tu.travel.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        System.out.println("22222222");
        //System.out.println(authentication.getName());
        //LOG.debug("Token requested for user: '{}'", authentication.getName());
       // String token = tokenService.generateToken(authentication);
       // LOG.debug("Token granted: {}", token);
        return "token";
    }

}