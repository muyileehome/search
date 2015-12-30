package com.yl.service;

import com.yl.util.DateStyle;
import com.yl.util.DateUtil;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/12/14.
 */
public class Test2 extends Test {

    public static void main(String[] args) {
        String time="昨天09:05";
       Pattern pattern = Pattern.compile("^昨天(([0-9]|:)*?$)");
       Matcher matcher =pattern.matcher(time);
        while (matcher.find()){
            String partTime=matcher.group(1);
            String dateTime=DateUtil.DateToString(new Date(System.currentTimeMillis()), DateStyle.YYYY_MM_DD);
            System.out.println((dateTime+" "+partTime+":00"));
            break;
        }
    }
}
