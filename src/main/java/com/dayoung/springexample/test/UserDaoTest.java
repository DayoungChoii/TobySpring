package com.dayoung.springexample.test;

import com.dayoung.springexample.bean.User;
import com.dayoung.springexample.dao.UserDao;
import com.dayoung.springexample.service.DAOFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        User user1 = new User("11111", "김연경");
        User user2 = new User("22222", "김희진");

        dao.add(user1);
        dao.add(user2);

        assertThat(dao.getCount(), is(2));

        User userGet1 = dao.get(user1.getEmpNo());
        User userGet2 = dao.get(user2.getEmpNo());

        assertThat(userGet1.getUserName(), is(user1.getUserName()));
        assertThat(userGet1.getEmpNo(), is(user1.getEmpNo()));

        assertThat(userGet2.getUserName(), is(user2.getUserName()));
        assertThat(userGet2.getEmpNo(), is(user2.getEmpNo()));



    }

    @Test
    public void count() throws SQLException{
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao userdao = context.getBean("userDao", UserDao.class);
        User user1 = new User( "22222", "김희진");
        User user2 = new User("33333", "양희진");
        User user3 = new User("44444", "박정아");

        userdao.deleteAll();
        assertThat(userdao.getCount(), is(0));

        userdao.add(user1);
        assertThat(userdao.getCount(), is(1));

        userdao.add(user2);
        assertThat(userdao.getCount(), is(2));

        userdao.add(user3);
        assertThat(userdao.getCount(), is(3));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException{
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("unknown_empNo");
    }
}
