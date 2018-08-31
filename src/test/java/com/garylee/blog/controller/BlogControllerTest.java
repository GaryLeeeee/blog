package com.garylee.blog.controller;


import com.garylee.blog.domain.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogControllerTest {
    @Autowired
    BlogController blogController;
    @Test
    public void get() throws Exception {
        Blog blog = blogController.get(9);
        System.out.println(blog.getCreatetime());
    }

    @Test
    public void list() throws Exception {
//        List<Blog> blogs = blogController.list();
//        System.out.println(blogs.get(3).getContent());
    }

    @Test
    public void add() throws Exception {
        Blog blog = new Blog();
//        Blog.setId(1);
        blog.setTitle("念在天涯，心在咫尺");
        blog.setContent("正文");
        blog.setCreatetime(new Date());
        blog.setReadnum(777);
        blog.setIstop(0);
        blogController.add(blog);
    }

}