package com.dsczs.mapper;

import com.dsczs.model.User;

import java.util.List;

public interface UserMapper {

    void insertBatch(List<User> list);

    List<User> selectList();
}
