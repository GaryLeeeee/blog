package com.garylee.blog.service.impl;

import com.garylee.blog.dao.BlogMapper;
import com.garylee.blog.domain.Blog;
import com.garylee.blog.domain.BlogExample;
import com.garylee.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GaryLee on 2018-08-28 16:25.
 */
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogMapper blogMapper;

    @Override
    public void add(Blog blog) {
        blogMapper.insert(blog);
    }

    @Override
    public void delete(int id) {
        blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Blog blog) {
        blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public Blog get(int id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Blog> list() {
        BlogExample blogExample = new BlogExample();
        blogExample.setOrderByClause("id desc");
        return blogMapper.selectByExample(blogExample);
    }
}
