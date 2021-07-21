package com.dayoung.springexample.test;

import com.dayoung.springexample.bean.User;
import com.dayoung.springexample.dao.UserDao;
import com.dayoung.springexample.service.DAOFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DAOFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);


        User user2 = dao.get("1");
        System.out.println(user2.getUserName()+" 조회성공!");
    }
}
