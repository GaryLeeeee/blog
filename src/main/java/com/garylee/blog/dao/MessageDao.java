package com.garylee.blog.dao;

import com.garylee.blog.domain.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageDao {
    @Select("select * from message where id = #{id}")
    public Message queryMessage(int id);

    @Insert("insert into message (type,target_id,uid,nickname,message,create_time)values (#{message.type},#{message.targetId},#{message.uid},#{message.nickname},#{message.message},#{message.createTime})")
    public long addMessage(@Param("message")Message message);

    @Delete("delete from message values #{id}")
    public long deleteMesaage(int id);

    @Select("select * from message where type = #{type} and target_id = #{targetId} order by id desc")
    public List<Message> listMessages(@Param("type") int type,@Param("targetId") int targetId);
}
