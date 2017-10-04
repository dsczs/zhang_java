package com.dsczs.service;

import com.dsczs.model.Book;

import java.util.List;

public interface BookService {

    Book getById(long bookId);

    List<Book> getList();

}
