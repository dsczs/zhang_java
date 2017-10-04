package com.dsczs.service.impl;

import com.dsczs.mapper.BookMapper;
import com.dsczs.model.Book;
import com.dsczs.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book getById(long bookId) {
        return bookMapper.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookMapper.queryAll(0, 1000);
    }


}
