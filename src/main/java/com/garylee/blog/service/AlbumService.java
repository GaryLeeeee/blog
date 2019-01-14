package com.garylee.blog.service;

import com.garylee.blog.domain.Album;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AlbumService {
    void add(Album album);
    void upload(MultipartFile multipartFile, int id);
    Album get(int id);
    List<Album> list();

}
