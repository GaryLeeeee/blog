package com.garylee.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by GaryLee on 2018-08-30 21:34.
 */
public class DateUtil {
    public static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }
}
