package com.dsczs.controller;

import com.alibaba.fastjson.JSONObject;
import com.dsczs.mapper.UserMapper;
import com.dsczs.model.Book;
import com.dsczs.model.User;
import com.dsczs.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    private String list(Model model) {
        List<Book> list = bookService.getList();
        return JSONObject.toJSONString(list);
    }

    @ResponseBody
    @RequestMapping(value = "/testBatchInsert")
    private String testBatchInsert() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setName("a" + i);
            users.add(user);
        }

        int batchSize = 200;
        int size = 5;
        for (int j = 0; j < size; j++) {
            userMapper.insertBatch(users.subList(j * batchSize, j * batchSize + batchSize - 1));
        }

        List<User> list = userMapper.selectList();
        return JSONObject.toJSONString(list);
    }

}
