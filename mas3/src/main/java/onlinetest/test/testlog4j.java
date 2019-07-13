package onlinetest.test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class testlog4j {
    static Logger logger =
            Logger.getLogger(testlog4j.class);
    //.getLogger方法;传入类名获取日志对象
    public static void main(String[] args)
            throws InterruptedException {
        PropertyConfigurator.configure("log4j.properties");
        //默认配置

        for(int i=0;i<20;i++){
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }}
}
