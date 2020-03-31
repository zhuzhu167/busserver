package com.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liangzhu
 * @title: GetNowDate
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-1315:50
 */
public class GetNowDate {
    public static String getDate(Date date) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sim.format(date);
    }
}
