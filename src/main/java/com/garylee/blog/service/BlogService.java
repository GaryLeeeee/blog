package com.garylee.blog.service;

import com.garylee.blog.domain.Blog;

import java.util.List;

public interface BlogService {
    void add(Blog blog);
    void delete(int id);
    void update(Blog blog);
    Blog get(int id);
    List<Blog> list();
}
