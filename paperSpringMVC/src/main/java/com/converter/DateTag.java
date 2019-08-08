package com.converter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends TagSupport {
    private String value;
    @Override
    public int doStartTag() throws JspException {
        long time1;
        String vv = "" + value;
        try {
            //vv的trim方法 用于删除字符串头尾空白符
            //将string转long
            long time = Long.valueOf(vv.trim());
            //getInstance方法 获得一个Calendar实例
            Calendar c = Calendar.getInstance();
            //setTimeInMillis啥意思
            c.setTimeInMillis(time );
            SimpleDateFormat dateformat = new SimpleDateFormat
                    ("yyyy-MM-dd HH:mm:ss");

            String s = dateformat.format(c.getTime());
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