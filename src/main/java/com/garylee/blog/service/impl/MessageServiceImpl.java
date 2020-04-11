package com.garylee.blog.service.impl;

import com.garylee.blog.dao.MessageDao;
import com.garylee.blog.domain.Message;
import com.garylee.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GaryLee on 2020-01-22 22:17.
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    MessageDao messageDao;

    @Override
    public void leaveMessage(Message message) {
        messageDao.addMessage(message);
    }

    @Override
    public long deleteMessage(int id) {
        return messageDao.deleteMesaage(id);
    }

    @Override
    public Message getMessage(int id) {
        return messageDao.queryMessage(id);
    }

    @Override
    public List<Message> listMessages(int type,int targetId) {
        return messageDao.listMessages(type,targetId);
    }
}
