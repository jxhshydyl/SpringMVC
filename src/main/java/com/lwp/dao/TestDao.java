package com.lwp.dao;

import com.lwp.dto.User;

import java.util.List;

public interface TestDao {
    int insert(User user);
    List<User> select();
}
