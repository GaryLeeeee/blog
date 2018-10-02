package com.garylee.blog.controller;

import com.garylee.blog.domain.BlogLike;
import com.garylee.blog.service.BlogLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by GaryLee on 2018-10-02 14:56.
 */
@Controller
public class BlogLikeController {
    @Autowired
    BlogLikeService blogLikeService;
    @RequestMapping("blogLike")
    @ResponseBody
    public String blogLike(BlogLike blogLike){
//        blogLikeService.add(blogLike);
        return blogLikeService.add(blogLike)?"点赞成功":"你已点过赞";
    }
}
