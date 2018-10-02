package com.garylee.blog.dao;

import com.garylee.blog.domain.BlogLike;
import com.garylee.blog.domain.BlogLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogLikeMapper {
    long countByExample(BlogLikeExample example);

    int deleteByExample(BlogLikeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogLike record);

    int insertSelective(BlogLike record);

    List<BlogLike> selectByExample(BlogLikeExample example);

    BlogLike selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogLike record, @Param("example") BlogLikeExample example);

    int updateByExample(@Param("record") BlogLike record, @Param("example") BlogLikeExample example);

    int updateByPrimaryKeySelective(BlogLike record);

    int updateByPrimaryKey(BlogLike record);
}