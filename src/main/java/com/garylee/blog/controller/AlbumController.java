package com.garylee.blog.controller;

import com.garylee.blog.dao.AlbumDao;
import com.garylee.blog.domain.Album;
import com.garylee.blog.domain.Blog;
import com.garylee.blog.domain.Picture;
import com.garylee.blog.service.AlbumService;
import com.garylee.blog.service.PictureService;
import com.garylee.blog.utils.FileUpload;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by GaryLee on 2019-01-13 00:35.
 * 相册controller
 */
@Controller
public class AlbumController {
    @Autowired
    AlbumService albumService;
    @Autowired
    PictureService pictureService;
    @Autowired
    AlbumDao albumDao;
    @RequestMapping("addAlbum")
    public String addAlbum(Album album){
        album.setCreatetime(new Date());
        albumService.add(album);
        return "redirect:/upload?aid="+album.getId();
    }
    /** 
    * @Description:
    * @Param:  
    * @return:  
    * @Date: 2019/01/13 18:16
    */ 
    @RequestMapping("upload/UploadAction")
    @ResponseBody
    public void add(@RequestParam("aid")int aid,@RequestParam("fileList") MultipartFile multipartFile){


        //每张图片请求一次
        System.out.println("aid:"+aid);
        Picture picture = new Picture();
        picture.setAid(aid);
        pictureService.add(picture);
//    FileUpload.upload(request);
        //存放到本地，并上传到阿里云oss
        albumService.upload(multipartFile,picture.getId());
    }
    @RequestMapping("getAlbum")
    @ResponseBody
    public Album getAlbum(int id){
        return albumService.get(id);
    }
    @RequestMapping("listAlbum")
    @ResponseBody
    public List<Album> listAlbum(){
        return albumService.list();
    }
    @RequestMapping("getAlbumPageInfo")
    @ResponseBody
    public PageInfo list(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "8")int size){
        PageHelper.startPage(start,size);
        PageInfo<Album> page = new PageInfo<>(albumService.list());
        return page;
    }
    @RequestMapping("deleteAlbum")
    public String deleteBlog(int id){
        albumService.delete(id);
        return "redirect:/share";
    }
    @RequestMapping("getPreviousAlbum")
    @ResponseBody
    public Album getPreviousAlbum(int id){
        Album album = albumDao.getPerviousAlbum(id);
        System.out.println("getPreviousAlbum album:"+album);
        return album;
    }

    @RequestMapping("getNextAlbum")
    @ResponseBody
    public Album getNextAlbum(int id){
        Album album = albumDao.getNextAlbum(id);
        return album;
    }
}
