package com.garylee.blog.service;

import com.garylee.blog.domain.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id);
    void update(User user);
    User get(int id);
    List<User> list();
}
