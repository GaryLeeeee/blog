package com.garylee.blog.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.*;

/**
 * Created by GaryLee on 2019-01-13 00:45.
 */
public class OssUtils {
    private static String accessKeyId = null;
    private static String accessKeySecret = null;

    //用本地文档初始化access key，避免被恶意
    static {
        File file = new File("d:\\Users\\Administrator\\Desktop\\Access-Key.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            accessKeyId = reader.readLine();
            accessKeySecret = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void upload(String filename,String bucket){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//        String accessKeyId = "************";
//        String accessKeySecret = "****************";

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        File file = new File("d:\\Users\\Administrator\\Desktop\\blog-picture\\"+filename);
        ossClient.putObject(bucket, filename, file);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void main(String[] args) {
//        upload("wechat.png","lee-images");

    }
}
