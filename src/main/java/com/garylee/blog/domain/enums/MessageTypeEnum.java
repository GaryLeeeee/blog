package com.garylee.blog.domain.enums;

public enum MessageTypeEnum {
    BLOG_MESSAGE(1,"日志留言"),
    PICTURE_MESSAGE(2,"相册留言"),
    COMMON_MESSAGE(3,"公共留言");
    int code;
    String desc;

    MessageTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
}
