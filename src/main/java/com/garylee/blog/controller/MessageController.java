package com.garylee.blog.controller;

import com.garylee.blog.dao.BlogDao;
import com.garylee.blog.domain.Blog;
import com.garylee.blog.domain.Message;
import com.garylee.blog.domain.User;
import com.garylee.blog.service.BlogService;
import com.garylee.blog.service.MessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by GaryLee on 2018-08-28 16:30.
 */
@Controller
public class MessageController {
    @Autowired
    MessageService messageService;
    @RequestMapping("getMessagePageInfo")
    @ResponseBody
    public PageInfo listCommonMessage(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "10")int size,@RequestParam("type")int type,@RequestParam("targetId")int targetId){
        PageHelper.startPage(start,size);
        PageInfo<Message> page = new PageInfo<>(messageService.listMessages(type,targetId));
        return page;
    }
    @RequestMapping("leaveMessage")
    public String addMessage(@Param("message") Message message){
        System.out.println("message:"+message);
        if(message.getNickname()==null){
            return "login";
        }
        message.setCreateTime(new Date());
        messageService.leaveMessage(message);
        return "gbook";
    }
    @RequestMapping("deleteMessage")
    public String deleteBlog(int id){
        messageService.deleteMessage(id);
        return "redirect:/gbook";
    }
}
