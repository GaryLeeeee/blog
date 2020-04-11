package com.garylee.blog.dao;

import com.garylee.blog.domain.Album;
import org.apache.ibatis.annotations.Select;

public interface AlbumDao {
    @Select(" select * from album where id < #{id} order by id desc  limit 1")
    public Album getPerviousAlbum(int id);

    @Select(" select * from album where id > #{id} limit 1")
    public Album getNextAlbum(int id);
}
