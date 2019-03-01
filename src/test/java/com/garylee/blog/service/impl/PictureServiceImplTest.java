package com.garylee.blog.service.impl;

import com.garylee.blog.domain.Picture;
import com.garylee.blog.service.PictureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureServiceImplTest {
    @Autowired
    PictureService pictureService;
    @Test
    public void show() throws Exception {
        List<Picture> pictures = pictureService.show();
        for(Picture picture:pictures){
            System.out.println("id:"+picture.getId());
            System.out.println();
        }
    }

}