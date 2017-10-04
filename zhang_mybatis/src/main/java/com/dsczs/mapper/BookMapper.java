package com.dsczs.mapper;

import com.dsczs.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    Book queryById(long id);

    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);


}
