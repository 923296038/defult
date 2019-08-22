import com.pojo.Studio;
import com.service.RoleService;
import com.service.StudioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestStudio {
    private static final Logger log = LogManager.getLogger(TestStudio.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    StudioService studioService = (StudioService) context.getBean("studioService");
    /*@Test
    public void testI(){
        Studio studio = new Studio();
        Studio studio1 = new Studio();
        Studio studio2 = new Studio();
        studio.setStudio_name("LOL代练");
        studio1.setStudio_name("DNF代练");
        studio2.setStudio_name("YYS代练");
        studioService.insert(studio);
        studioService.insert(studio1);
        studioService.insert(studio2);
    }
    @Test
    public void testD(){
        studioService.deleteByPrimaryKey(3L);
    }
    @Test
    public void testU(){
        Studio studio = new Studio();
        studio.setStudio_name("测试update");
        studio.setId(2L);
        studioService.updateByPrimaryKey(studio);
    }
    @Test
    public void testFBPK(){
        List<Studio> studioList=studioService.findByStudioName("YYS代练");
        log.error(studioList);

    }
    @Test
    public void testFA(){
        List<Studio> studioList=studioService.findAll();
        log.error(studioList);

    }
    @Test
    public void testUpS(){
        studioService.upStudio(1L);
    }
    @Test
    public void testDownS(){
        studioService.downStudio(2L);
    }*/
}
