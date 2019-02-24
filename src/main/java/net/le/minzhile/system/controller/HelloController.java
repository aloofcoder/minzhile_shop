package net.le.minzhile.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping
    public String hello() {
        log.debug("hello world");
        return "hello world" ;
    }

}
