package com.zhang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OkHttpController {

    @PostMapping(value = "/post1")
    public void testPost(String name) {
        System.out.println(name);
    }
}
