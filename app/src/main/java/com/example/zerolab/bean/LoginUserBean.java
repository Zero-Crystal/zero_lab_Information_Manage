package com.example.zerolab.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author DELL
 */
public class LoginUserBean {
    @SerializedName("params")
    private LoginUser user;

    public LoginUser getUser() {
        return user;
    }

    public void setUser(LoginUser user) {
        this.user = user;
    }

    public static class LoginUser {
        private String result;
        private String userNum;
        private String userStatus;
        private String userCollege;
        private String userName;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getUserNum() {
            return userNum;
        }

        public void setUserNum(String userNum) {
            this.userNum = userNum;
        }

        public String getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(String userStatus) {
            this.userStatus = userStatus;
        }

        public String getUserCollege() {
            return userCollege;
        }

        public void setUserCollege(String userCollege) {
            this.userCollege = userCollege;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
