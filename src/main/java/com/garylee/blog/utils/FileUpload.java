package com.garylee.blog.utils;

import com.garylee.blog.domain.Album;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;

/**
 * Created by GaryLee on 2019-01-13 16:32.
 * 文件上传，支持批量上传，测试zyupload通过
 * zyupload是多次请求request的，并不是一次request
 */
public class FileUpload {
    public static void upload(HttpServletRequest req){
            //创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(req.getSession().getServletContext());
            //判断 request 是否有文件上传,即多部分请求
            if(multipartResolver.isMultipart(req)){
                //转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) req;
                // 取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                int i =0;
                if(iter.hasNext()) {
                    // 取得上传文件
                    MultipartFile file = multiRequest.getFile(iter.next());

                    System.out.println("i"+(i++));
                    //获取文件名
                    String fileName = file.getOriginalFilename();
                    //保存到本地
                    File files = new File("d:\\Users\\Administrator\\Desktop\\blog-picture\\"+fileName);
                    if(!files.getParentFile().exists())
                        files.getParentFile().mkdirs();
                    try {
                        file.transferTo(files);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

    }
    public static void upload2(HttpServletRequest request){

    }

    public static void main(String[] args) {

    }
}
