package com.dayoung.springexample.dao;

import com.dayoung.springexample.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class DAOFactory {
    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker (){
        return new DConnectionMaker();
    }
}
