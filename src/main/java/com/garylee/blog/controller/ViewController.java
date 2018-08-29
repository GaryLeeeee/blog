package com.garylee.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by GaryLee on 2018-08-28 18:05.
 */
@Controller
public class ViewController {
    @RequestMapping("info")
    public String info(){
        return "info";
    }
    @RequestMapping("about")
    public String about(){
        return "about";
    }
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("infopic")
    public String infopic(){
        return "infopic";
    }
    @RequestMapping("gbook")
    public String gbook(){
        return "gbook";
    }
    @RequestMapping("list")
    public String list(){
        return "list";
    }
    @RequestMapping("share")
    public String share(){
        return "share";
    }
    @RequestMapping("edit")
    public String edit(){
        return "edit";
    }
    @RequestMapping("bianjiqi")
    public String editDemo(){
        return "bianjiqi";
    }
}
