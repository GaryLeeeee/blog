package com.garylee.blog.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogLikeServiceImplTest {
    @Autowired
    BlogLikeServiceImpl blogLikeService;
    @Test
    public void existIp() throws Exception {
        System.out.println(blogLikeService.existIp(1,"123.0.0.1"));
    }

    @Test
    public void likeNum() throws Exception {
        System.out.println(blogLikeService.likeNum(1));
    }
}