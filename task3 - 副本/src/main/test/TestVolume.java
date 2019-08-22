import com.pojo.Volume;
import com.service.VolumeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestVolume {
    private static final Logger log = LogManager.getLogger(TestVolume.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    VolumeService volumeService= (VolumeService) context.getBean("volumeService");
    /*@Test
    public void testI(){
        Volume volume = new Volume();
        volume.setVolume_name("wang");
        volumeService.insertVolume(volume);
    }
    @Test
    public void testU(){
        Volume volume = new Volume();
        volume.setUpdate_by("chen");
        volume.setId(2);
        volumeService.updateVolume(volume);
    }
    @Test
    public void testD(){
        volumeService.deleteVolume(3L);
    }
    @Test
    public void testFBN(){
        List<Volume> volumeList =volumeService.findByName("test");
        log.error(volumeList);
    }
    @Test
    public void testFA(){
        List<Volume> volumeList=volumeService.findAll();
        log.error(volumeList);
    }
    @Test
    public void testUV(){
        volumeService.upVolume(1L);
    }
    @Test
    public void testDV(){
        volumeService.downVolume(1L);
    }*/
}
