package com.timeUtil;

import org.springframework.stereotype.Component;

//一个转型方法
@Component
public class StringUtil {
    String name = "a";
    public String convert(String name) {
        if (name == " " || name == null){
            this.name = null;
        }
        return this.name;
    }
}
