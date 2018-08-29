package com.garylee.blog.controller;

import com.garylee.blog.domain.Blog;
import com.garylee.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by GaryLee on 2018-08-28 16:30.
 */
@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @RequestMapping("listBlog")
    @ResponseBody
    public List<Blog> list(){
        return blogService.list();
    }
    @RequestMapping("addBlog")
    public String add(Blog blog){
        blog.setCreatetime(new Date().toString());
        blogService.add(blog);
        return "info";
    }
    @RequestMapping("getBlog")
    @ResponseBody
    public Blog get(int id){
        return blogService.get(id);
    }

    public static void main(String[] args) {
        System.out.println(new Date().toString());
    }
}
