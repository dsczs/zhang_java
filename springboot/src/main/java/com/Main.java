package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Main {
    @Value("${spring.datasource.username}")
    private String username;

    @GetMapping(value = "/t1")
    @ResponseBody
    public String t1() {
        return username;
    }
}
