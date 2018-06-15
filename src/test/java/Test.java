import com.lwp.dao.TestDao;
import com.lwp.dto.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class Test {
    @Autowired
    TestDao testDao;

    @org.junit.Test
    @Transactional
    public void test(){
        User user=new User();
        user.setName("lwp");
        user.setPassword("123");
        int insert = testDao.insert(user);
        int i=testDao.insert(user);
        System.out.println(insert+i);
    }

    @org.junit.Test
    public void test1(){
        User user=new User();
        user.setName("lwp");
        user.setPassword("123");
        List<User> list=testDao.select();
        System.out.println(list);
    }
}
