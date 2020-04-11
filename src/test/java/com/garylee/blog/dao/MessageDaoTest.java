package com.garylee.blog.dao;

import com.garylee.blog.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDaoTest {
    @Autowired
    MessageDao messageDao;
    @Autowired
    AlbumDao albumDao;

    @Test
    public void testForAlbum(){
        System.out.println(albumDao.getPerviousAlbum(14));
    }
    @Test
    public void queryMessage() throws Exception {
    }

    @Test
    public void addMessage() throws Exception {
        Message messagew  = new Message();
        messagew.setCreateTime(new Date());
        messagew.setNickname("李白");
        messagew.setUid(123);
        messagew.setTargetId(-1);
        messagew.setType(3);
        messageDao.addMessage(messagew);
    }

    @Test
    public void deleteMesaage() throws Exception {
    }

    @Test
    public void listMessages() throws Exception {
    }

}