import com.mapper.AccountMapper;
import com.pojo.Account;
import com.pojo.Banner;
import com.service.AccountService;
import com.service.BannerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.rmi.runtime.Log;

import java.lang.ref.SoftReference;
import java.util.List;

public class TestBanner {
    private static final Logger log = LogManager.getLogger(TestBanner.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    BannerService bannerService = (BannerService) context.getBean("bannerService");
    /*@Test
    public void testInsert(){
        Banner banner = new Banner("wang","1","下架",1,1);
        bannerService.insertBanner(banner);
    }
    @Test
    public void testFindAll(){
        List<Banner> bannerList = bannerService.findAllBanner();
        log.error(bannerList);
    }
    @Test
    public void testFindByName(){
        List<Banner> bannerList = bannerService.findByName("wang");
        log.error(bannerList);
    }
    @Test
    public void testDelete(){
        bannerService.deleteBanner(8);
    }
    @Test
    public void testUpdate(){
        Banner banner = new Banner("chen","1","下架",1,1);
        banner.setId(8);
        bannerService.updateBanner(banner);
    }

    @Test
    public void testUpBanner(){
        bannerService.upBanner(8);
    }

    @Test
    public void testDownBanner(){
        bannerService.downBanner(8);
    }*/
}
