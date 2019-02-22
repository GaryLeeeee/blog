package com.garylee.blog.service.impl;

import com.garylee.blog.dao.BlogMapper;
import com.garylee.blog.domain.Blog;
import com.garylee.blog.domain.BlogExample;
import com.garylee.blog.domain.BlogLike;
import com.garylee.blog.service.BlogLikeService;
import com.garylee.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GaryLee on 2018-08-28 16:25.
 */
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    BlogLikeService blogLikeService;
    @Override
    public void add(Blog blog) {
        blogMapper.insert(blog);
    }

    @Transactional
    @Override
    // TODO: 2019/2/22 0022 删除blog同时删除blogLike(有关联外键),后续可用级联删除 
    public void delete(int id) {
        List<BlogLike> blogLikes = blogLikeService.list(id);
        for(BlogLike blogLike:blogLikes){
            blogLikeService.delete(blogLike.getId());
        }
        
        blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Blog blog) {
        blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public Blog get(int id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        blog.setLikeNum(blogLikeService.likeNum(blog.getId()));//设置点赞数量
        return blog;
    }

    @Override
    public List<Blog> list() {
        BlogExample blogExample = new BlogExample();
        blogExample.setOrderByClause("id desc");
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        for(Blog blog:blogs)
            blog.setLikeNum(blogLikeService.likeNum(blog.getId()));
        return blogs;
    }
}
