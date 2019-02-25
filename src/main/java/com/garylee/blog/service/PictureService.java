package com.garylee.blog.service;

import com.garylee.blog.domain.Picture;

import java.util.List;

/**
 * Created by GaryLee on 2019-01-13 19:47.
 */
public interface PictureService {
    void add(Picture picture);
    List<Picture> list(int aid);
    void delete(int id);
    List<Picture> show();
}
