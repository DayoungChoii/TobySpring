package com.dayoung.springexample.dao;

import com.dayoung.springexample.bean.User;

import java.sql.*;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public void setConnectionMaker(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into org_employee(EMP_NO, USER_NAME) values(?,?)");

        ps.setString(1, user.getEmpNo());
        ps.setString(2, user.getUserName());

        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public User get(String empNo) throws ClassNotFoundException, SQLException {

        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from org_employee where user_name = ?");
        ps.setString(1, "최주영");


        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setEmpNo(rs.getString("emp_no"));
        user.setUserName(rs.getString("user_name"));

        rs.close();
        ps.close();
        c.close();

        return user;

    }

    /*private Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "devuser", "devuser");

        return c;
    }*/
}
