package com.dayoung.springexample.test;

import com.dayoung.springexample.bean.User;
import com.dayoung.springexample.dao.DAOFactory;
import com.dayoung.springexample.dao.UserDao;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        DAOFactory factory = new DAOFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();

        System.out.println(dao1);
        System.out.println(dao2);
        /*UserDao dao = new UserDao();

        User user = new User();
        user.setEmpNo("5");
        user.setUserName("최주영");

//        dao.add(user);

//        System.out.println(user.getEmpNo()+" 등록성공!");

        User user2 = dao.get("1");
        System.out.println(user2.getUserName()+" 조회성공!");*/

    }
}
