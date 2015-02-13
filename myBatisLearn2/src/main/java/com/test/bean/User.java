package com.test.bean;

import java.util.Date;

public class User {

    private int uid;
    private String token;
    private String account;
    private String password;
    private String userName;
    private Date createdDate;

    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "-------\nuid:"+uid+"\ntoken:"+token+"\naccount:"+account+"\nuserName:"+userName+"\ncreatedDate:"+createdDate;
    }

}
