package com.dayoung.springexample.test;

import com.dayoung.springexample.bean.User;
import com.dayoung.springexample.dao.ConnectionMaker;
import com.dayoung.springexample.dao.DAOFactory;
import com.dayoung.springexample.dao.DConnectionMaker;
import com.dayoung.springexample.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        ApplicationContext context = new AnnotationConfigApplicationContext(DAOFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user2 = dao.get("1");
        System.out.println(user2.getUserName()+" 조회성공!");
    }
}
