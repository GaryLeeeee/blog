package com.garylee.blog.controller;

import com.garylee.blog.domain.Picture;
import com.garylee.blog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by GaryLee on 2019-01-13 22:50.
 */
@Controller
public class PictureController {
    @Autowired
    PictureService pictureService;
    @RequestMapping("addPicture")
    @ResponseBody
    public void addPicture(Picture picture){
        pictureService.add(picture);
    }
    @RequestMapping("listPictures")
    @ResponseBody
    public List<Picture> listPicture(int aid){
        return pictureService.list(aid);
    }
    @RequestMapping("showPictures")
    @ResponseBody
    public List<Picture> showPicture(){
        return pictureService.show();
    }
}
