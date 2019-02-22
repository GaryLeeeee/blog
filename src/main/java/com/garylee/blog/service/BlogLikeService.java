package com.garylee.blog.service;

import com.garylee.blog.domain.Blog;
import com.garylee.blog.domain.BlogLike;

import java.util.List;

public interface BlogLikeService {
    boolean add(BlogLike blogLike);
    void delete(int id);
    void update(BlogLike blogLike);
    BlogLike get(int id);
    boolean existIp(int blogId,String ip);
    int likeNum(int blogId);
    List<BlogLike> list(int blogId);
}
