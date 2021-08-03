package com.dayoung.springexample.dao;

import com.dayoung.springexample.bean.User;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {

        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into org_employee(EMP_NO, USER_NAME) values(?,?)");

        ps.setString(1, user.getEmpNo());
        ps.setString(2, user.getUserName());

        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public User get(String empNo) throws ClassNotFoundException, SQLException {

        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from org_employee where emp_no = ?");
        ps.setString(1, empNo);


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

    public void deleteAll() throws SQLException{
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("delete from org_employee");
        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public int getCount() throws SQLException{
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("select count(*) from org_employee");

        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        rs.close();
        ps.close();
        c.close();

        return count;
    }
}
