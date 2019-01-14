package com.garylee.blog.domain;

import java.util.Date;

public class Album {
    private Integer id;

    private String title;

    private String content;

    private Date createtime;

    //非数据库字段
    //方便list显示
    private int firstPictureId;

    public Integer getId() {
        return id;
    }

    public int getFirstPictureId() {
        return firstPictureId;
    }

    public void setFirstPictureId(int firstPictureId) {
        this.firstPictureId = firstPictureId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}