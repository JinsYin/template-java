package cn.guruguru.template.api.service.impl;

import cn.guruguru.template.api.service.GreetService;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceImpl implements GreetService {
    @Override
    public String hello(String person) {
        return "Hello, " + person;
    }
}
