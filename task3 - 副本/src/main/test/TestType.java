import com.service.StudioService;
import com.service.TypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import com.pojo.Type;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestType {
    private static final Logger log = LogManager.getLogger(TestType.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TypeService typeService = (TypeService) context.getBean("typeService");
    /*@Test
    public void testI(){
        Type type = new Type();
        Type type1 = new Type();
        Type type2 = new Type();
        type.setType_name("黄色");
        type1.setType_name("无内鬼");
        type2.setType_name("与玫瑰");
        typeService.insert(type);
        typeService.insert(type1);
        typeService.insert(type2);
    }

    @Test
    public void testF(){
        List<Type> typeList = typeService.findByTypeName("无内鬼");
        List<Type> typeList1 = typeService.findAll();
        log.error("名字查询"+typeList);
        log.error("所有查询"+typeList1);

    }
    @Test
    public void testUaD(){
        Type type = new Type();
        type.setType_name("测试update");
        type.setId(1L);
        typeService.updateByPrimaryKey(type);

        typeService.deleteByPrimaryKey(3L);
    }
    @Test
    public void testUoD(){
        typeService.upType(1L);
        typeService.downType(2L);
    }*/
}
