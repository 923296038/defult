package com.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Dawn on 2018/3/30.
 */
//实现泛型接口，String是传进来的字符串，Date是要返回的日期类型
public class MyDateConverter implements Converter<String,Date> {
    public Date convert(String str) {
        /*获取下面方法返回的SimpleDateFormat*/
        SimpleDateFormat sdf=getSimpleDate(str);
        try {
            /*转换Date类型后返回*/
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*根据字符串的格式自定义转换的格式*/
    private SimpleDateFormat getSimpleDate(String str) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        if(Pattern.matches("^\\d{4}-\\d{1,2}-\\d{2}$",str)){
            sdf=new SimpleDateFormat("yyyy-MM-dd");
        }
        if(Pattern.matches("^\\d{4}/\\d{1,2}/\\d{2}$",str)){
            sdf=new SimpleDateFormat("yyyy/MM/dd");
        }
        if(Pattern.matches("^\\d{4}\\d{1,2}\\d{2}$",str)){
            sdf=new SimpleDateFormat("yyyyMMdd");
        }
        return sdf;
    }


}