package com.garylee.blog.service.impl;

import com.garylee.blog.dao.AlbumMapper;
import com.garylee.blog.domain.Album;
import com.garylee.blog.domain.AlbumExample;
import com.garylee.blog.domain.Picture;
import com.garylee.blog.service.AlbumService;
import com.garylee.blog.service.PictureService;
import com.garylee.blog.utils.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by GaryLee on 2019-01-13 00:36.
 */
@Service
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    PictureService pictureService;
    @Override
    public void add(Album album) {
        albumMapper.insert(album);
    }

    @Override
    public void upload(MultipartFile multipartFile, int id) {
        //获取原文件名
        String filename = multipartFile.getOriginalFilename();
        //获取原文件后缀(可能有.jpg,.png等不同)
        String suffix = filename.substring(filename.indexOf("."));
        //保存到本地先
        File file = new File("d:\\Users\\Administrator\\Desktop\\blog-picture\\" + id +suffix);
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //上传到阿里云
        OssUtils.upload(file.getName(),"lee-blog-picture");
    }

    @Override
    public Album get(int id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Album> list() {
        AlbumExample example = new AlbumExample();
        example.setOrderByClause("id desc");
        List<Album> albums = albumMapper.selectByExample(example);
        //带上每个相册第一张图片
        setFirstPicture(albums);
        return albums;
    }
    //带上每个相册第一张图片
    public void setFirstPicture(List<Album> albums){
        for(Album album:albums){
            List<Picture> pictures = pictureService.list(album.getId());
            int pid = 0;
            //判断该相册是否有图片，没有则为0,0.jpg是404图片
            if(!pictures.isEmpty())
                pid = pictures.get(0).getId();
            album.setFirstPictureId(pid);
        }
    }
}
