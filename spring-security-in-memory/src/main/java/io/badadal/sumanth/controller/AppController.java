package io.badadal.sumanth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sbadadal
 */

@RestController
@RequestMapping("/inMemory")
public class AppController {

    @GetMapping("/test")
    public String test() {
        return "Hello From The Other Side";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello From The Other Side.... ";
    }
}
