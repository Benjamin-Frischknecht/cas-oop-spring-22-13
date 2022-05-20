package com.example.demoinitial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class DemoInitialApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoInitialApplication.class, args);
    }

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return "Hello World ok";
    }

    @RequestMapping("/goodbye")
    @ResponseBody
    String goodbye() {
        return "Goodbye ";
    }

}
