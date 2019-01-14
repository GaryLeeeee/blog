package com.garylee.blog.service.impl;

import com.garylee.blog.dao.PictureMapper;
import com.garylee.blog.domain.Picture;
import com.garylee.blog.domain.PictureExample;
import com.garylee.blog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GaryLee on 2019-01-13 19:47.
 */
@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    PictureMapper pictureMapper;
    @Override
    public void add(Picture picture) {
        pictureMapper.insert(picture);
    }

    @Override
    public List<Picture> list(int aid) {
        PictureExample example =  new PictureExample();
        example.createCriteria().andAidEqualTo(aid);
        List<Picture> pictures = pictureMapper.selectByExample(example);
        return pictures;
    }
}
