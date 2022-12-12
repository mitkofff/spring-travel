package com.tu.travel.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class HomeController {
    @GetMapping("")
    public String hello() {
        return "Hello Page";
    }
}
