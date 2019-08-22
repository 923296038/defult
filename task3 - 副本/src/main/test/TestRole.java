import com.service.RoleService;
import com.pojo.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestRole {
    private static final Logger log = LogManager.getLogger(TestRole.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    RoleService roleService = (RoleService) context.getBean("roleService");
    /*@Test
    public void testI(){
        Role role = new Role();
        Role role1 = new Role();
        Role role2 = new Role();
        role.setRole("管理员");
        role1.setRole("用户");
        role2.setRole("游客");
        roleService.insert(role);
        roleService.insert(role1);
        roleService.insert(role2);
    }
    @Test
    public void testD(){
        roleService.deleteByPrimaryKey(2L);
    }
    @Test
    public void testFBR(){
        List<Role> roleList =roleService.findByRole("游客");
        log.error(roleList);
    }
    @Test
    public void testFA(){
        List<Role> roleList = roleService.findAll();
        log.error(roleList);
    }
    @Test
    public void testU(){
        Role role = new Role();
        role.setRole("Update");
        role.setId(1L);
        roleService.updateByPrimaryKey(role);
    }*/
}
