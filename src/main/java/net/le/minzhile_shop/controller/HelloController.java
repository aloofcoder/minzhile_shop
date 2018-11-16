package net.le.minzhile_shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping
    public String hello () {
        log.debug("hello world");
        return "hello world";
    }
}
