package com.garylee.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by GaryLee on 2018-10-02 15:20.
 */
@Mapper
public interface BlogLikeDao {
    @Select("select ip from blog_like where ip = #{ip}")
    public boolean existIp(@Param("ip")String ip);
}
