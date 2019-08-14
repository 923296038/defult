package com.converter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends TagSupport {
    private String value;
    @Override
    public int doStartTag() throws JspException {

        String vv = "" + value;
        try {
            //vv的trim方法 用于删除字符串头尾空白符
            //将string转long
            long time = Long.valueOf(vv.trim());
            //getInstance方法 获得一个Calendar实例
            Calendar calendar = Calendar.getInstance();
            //setTimeInMillis啥意思
            calendar.setTimeInMillis(time );
            SimpleDateFormat dateformat = new SimpleDateFormat
                    ("yyyy-MM-dd HH:mm:ss");

            String s = dateformat.format(calendar.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
    public void setValue(String value) {
        this.value = value;
    }
}