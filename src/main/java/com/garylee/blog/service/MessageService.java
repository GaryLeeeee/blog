package com.garylee.blog.service;

import com.garylee.blog.domain.Message;

import java.util.List;

/**
 * Created by GaryLee on 2020-01-22 22:17.
 */
public interface MessageService {
    void leaveMessage(Message message);
    long deleteMessage(int id);
    Message getMessage(int id);
    List<Message> listMessages(int type,int targetId);
}
