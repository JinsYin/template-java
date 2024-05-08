package cn.guruguru.template.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Greet")
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
    @ApiOperation("Hello")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "person", value = "The person to greet")
    })
    public static String hello(@RequestParam("person") String person) {
        return "Hello, " + person;
    }

}
