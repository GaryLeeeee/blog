package com.garylee.blog.dao;

import com.garylee.blog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by GaryLee on 2018-11-11 21:06.
 */
@Mapper
public interface BlogDao {
    //点击排行,通过点击量排行,只显示top10
    @Select("select * from blog.blog order by readNum desc limit 10")
    public List<Blog> sortByReadNum();
}
