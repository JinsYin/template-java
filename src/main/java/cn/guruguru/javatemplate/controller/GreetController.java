package cn.guruguru.javatemplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping(path = "/greet")
public class GreetController {

    /**
     * Restful Example
     *
     * @param person the person to greet
     * @return a greeting
     */
    @GetMapping("/hello")
    public static String hello(@RequestParam("person") String person) {
        return "Hello, " + person;
    }

}
