package com.dayoung.springexample.test;

import com.dayoung.springexample.bean.User;
import com.dayoung.springexample.dao.UserDao;
import com.dayoung.springexample.service.DAOFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setEmpNo("11111");
        user.setUserName("김연경");

        dao.add(user);

        User user2 = dao.get(user.getEmpNo());

        assertThat(user2.getUserName(), is(user.getUserName()));
        assertThat(user2.getEmpNo(), is(user.getEmpNo()));
    }
}
