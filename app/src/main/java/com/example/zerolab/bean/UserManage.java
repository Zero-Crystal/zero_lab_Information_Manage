package com.example.zerolab.bean;

/**
 * @author DELL
 */
public class UserManage {
    private String userNum;
    private String userName;
    private static UserManage instance = null;

    private UserManage(){

    }

    public static UserManage getInstance(){
        if(instance == null){
            instance=new UserManage();
        }
        return instance;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
