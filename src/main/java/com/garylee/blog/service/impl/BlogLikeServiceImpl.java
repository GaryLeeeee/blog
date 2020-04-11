package com.garylee.blog.service.impl;

import com.garylee.blog.dao.BlogLikeDao;
import com.garylee.blog.dao.BlogLikeMapper;
import com.garylee.blog.domain.Blog;
import com.garylee.blog.domain.BlogLike;
import com.garylee.blog.domain.BlogLikeExample;
import com.garylee.blog.service.BlogLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by GaryLee on 2018-10-02 14:18.
 */
@Service
public class BlogLikeServiceImpl implements BlogLikeService{
    @Autowired
    BlogLikeMapper blogLikeMapper;

    @Autowired
    BlogLikeDao blogLikeDao;

    public static void main(String[] args) {
        List<Map<String,Object>> dynamicList = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("dynamic",2);
        map1.put("user",4);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("dynamic",3);
        map2.put("user",1);
        dynamicList.add(map1);
        dynamicList.add(map2);

        List<Map<String, Object>> officialList = dynamicList.stream().filter(i -> {
            return i.get("dynamic") .equals( 2);
        }).collect(Collectors.toList());

        System.out.println(officialList);
    }
    @Override
    public boolean add(BlogLike blogLike) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            if(existIp(blogLike.getBlogid(),ip))
                return false;
            blogLike.setIp(ip);
            blogLikeMapper.insert(blogLike);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void delete(int id) {
        blogLikeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(BlogLike blogLike) {
        blogLikeMapper.updateByPrimaryKeySelective(blogLike);
    }

    @Override
    public BlogLike get(int id) {
        return blogLikeMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean existIp(int blogId,String ip) {
        BlogLikeExample example = new BlogLikeExample();
        example.createCriteria().andIpEqualTo(ip).andBlogidEqualTo(blogId);
        List<BlogLike> blogLikes = blogLikeMapper.selectByExample(example);
        return !blogLikes.isEmpty();
    }

    public int likeNum(int blodId){
        BlogLikeExample example = new BlogLikeExample();
        example.createCriteria().andBlogidEqualTo(blodId);
        return blogLikeMapper.selectByExample(example).size();
    }

    @Override
    public List<BlogLike> list(int blogId) {
        BlogLikeExample example = new BlogLikeExample();
        example.createCriteria().andBlogidEqualTo(blogId);
        return blogLikeMapper.selectByExample(example);
    }
}
