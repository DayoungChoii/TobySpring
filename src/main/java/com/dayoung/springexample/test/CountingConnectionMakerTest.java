package com.dayoung.springexample.test;

import com.dayoung.springexample.service.CountingConnectionMaker;
import com.dayoung.springexample.service.CountingDaoFactory;
import com.dayoung.springexample.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class CountingConnectionMakerTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        dao.get("1");

        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection conter:" +  ccm.getCounter());

    }
}
