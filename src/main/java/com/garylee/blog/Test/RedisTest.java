package com.garylee.blog.Test;

import com.garylee.blog.utils.RedisConfig;
import com.garylee.blog.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by GaryLee on 2018-09-03 22:35.
 */
@Controller
public class RedisTest {
    @Cacheable(value = "abc",key = "name")
    public static void add(){
        System.out.println("redis");
    }

    public static void main(String[] args) {
//        add();
        try {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @RequestMapping("/like")
    @ResponseBody
    public String redis(){
        if(redisUtil.hasKey("user"))
            redisUtil.incr("user",1);
        else
            redisUtil.set("user",0);
        return "点赞成功";
    }
}
