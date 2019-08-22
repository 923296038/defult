import com.pojo.Module;
import com.service.ModuleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.util.List;

public class TestModule {
    private static final Logger log = LogManager.getLogger(TestModule.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    ModuleService moduleService = (ModuleService) context.getBean("moduleService");

    /*@Test
    public void testInsert(){
        Module module = new Module();
        module.setModule_name("留言");
        moduleService.insertModule(module);
        Module module2 = new Module();
        module.setModule_name("账户");
        moduleService.insertModule(module);
        Module module3 = new Module();
        module.setModule_name("banner");
        moduleService.insertModule(module);
    }
    @Test
    public void testFindAll(){
        List<Module> moduleList = moduleService.findAll();
        log.error(moduleList);
    }
    @Test
    public void testFindBy(){
        List<Module> moduleList = moduleService.findByModuleName("留言");
        log.error(moduleList);
    }
    @Test
    public void testDelete(){
        moduleService.deleteModule(3L);
    }
    @Test
    public void testUpdate(){
        Module module = new Module();
        module.setModule_name("留言2");
        module.setId(1);
        moduleService.updateModule(module);
    }*/

}
