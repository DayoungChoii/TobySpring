package com.dayoung.springexample.bean;

public class User {
    String empNo;
    String userName;

    public User(String empNo, String userName){
        this.empNo = empNo;
        this.userName = userName;
    }

    public User(){

    };

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
