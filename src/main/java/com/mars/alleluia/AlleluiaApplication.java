package com.mars.alleluia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication
public class AlleluiaApplication {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(AlleluiaApplication.class, args);
    }
}
