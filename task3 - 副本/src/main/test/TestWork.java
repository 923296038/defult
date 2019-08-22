import com.service.WorkService;
import com.pojo.Work;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestWork {
    private static final Logger log = LogManager.getLogger(TestWork.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    WorkService workService = (WorkService) context.getBean("workService");
    /*@Test
    public void test(){
        Work work = new Work();
        Work work1 = new Work();
        Work work2 = new Work();
        work.setWork_name("pornhub");
        work1.setWork_name("tumblr");
        work2.setWork_name("xvideos");
        workService.insert(work);
        workService.insert(work1);
        workService.insert(work2);
        List<Work> workList=workService.selectAll();
        log.error("新增后:"+workList);

        List<Work> workList1 = workService.selectByWorkName("pornhub");
        log.error("查单个"+workList1);

        work.setWork_name("测试更改");
        work.setId(1L);
        workService.updateByPrimaryKey(work);
        workService.deleteByPrimaryKey(3L);
        List<Work> workList3=workService.selectAll();
        log.error("更&删后:"+workList3);

        workService.upWork(1L);
        workService.downWork(2L);
        List<Work> workList2=workService.selectAll();
        log.error("上下架后:"+workList2);
    }*/
}
