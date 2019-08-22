import com.mapper.AccountMapper;
import com.pojo.Account;
import com.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.rmi.runtime.Log;

import java.lang.ref.SoftReference;
import java.util.List;

public class TestAccount {
    private static final Logger log = LogManager.getLogger(TestAccount.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    AccountService accountService = (AccountService) context.getBean("accountService");
    /*@Test
    public void testInsert(){
        Account account1 = new Account("wang","hero",1,"wang");
        log.error(account1);
        accountService.insertAccount(account1);
    }
    @Test
    public void testFindAll(){
        List<Account> accountList = accountService.findAllAccount();
        log.error(accountList);
    }
    @Test
    public void testFindByName(){
        List<Account> accountList = accountService.findByName("wang");
        log.error(accountList);
    }
    @Test
    public void testDelete(){
        accountService.deleteAccount(1);
    }
    @Test
    public void testUpdate(){
        Account account1 = new Account("chen","hero",1,"wang");
        account1.setId(1);
        log.error(account1);
        accountService.updateAccount(account1);
    }*/
}
