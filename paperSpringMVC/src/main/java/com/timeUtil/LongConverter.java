package com.timeUtil;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;

public class LongConverter implements Converter<String,Long> {
    //  //String (原数据的类型),long（转换后的数据类型）
    @Override
    public Long convert(String s) {
        //实现 将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
//转成直接返回,
            // format方法：将日期类型（Date）数据格式化为字符串（String）
            // parse方法：将字符串类型（java.lang.String）解析为日期类型（java.util.Date）
            System.out.println("time" + s);
            System.out.println("test:" + simpleDateFormat.parse(s));
            long slff=simpleDateFormat.parse(s).getTime()/1000;
            System.out.println("long:" + slff);
            return slff;
        } catch (Exception e) {
            e.printStackTrace();
        }
//如果参数绑定失败返回null
        return null;
    }
}