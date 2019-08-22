import com.pojo.Message;
import com.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.util.List;

public class TestMessage {
    private static final Logger log = LogManager.getLogger(TestMessage.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    MessageService messageService = (MessageService) context.getBean("messageService");

   /* @Test
    public void testInsert(){
        Message message=new Message();
        message.setUpdate_by("testI");
        messageService.insertMessage(message);
    }
    @Test
    public void testFindAll(){
        List<Message> messageList = messageService.findAllMessage();
        log.error(messageList);
    }
    @Test
    public void testFindBy(){
        List<Message> messageList=messageService.findByUserName("testI");
        log.error(messageList);
        Message message = messageService.findByID(2L);
        log.error(message);
    }
    @Test
    public void testDelete(){
        messageService.deleteMessage(1L);
    }
    @Test
    public void testUpdate(){
        Message message=new Message();
        message.setUpdate_by("testU");
        message.setId(1);
        messageService.updateMessage(message);
    }

    @Test
    public void testUp(){
        messageService.upMessage(1L);
    }

    @Test
    public void testDown(){
        messageService.downMessage(1L);
    }*/
}
