package com.qianfeng.mybatis.dto;

/**
 * Created by Mao on 2018/3/19.
 */
public class UserDTO {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_email;
    private char user_sex;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public char getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(char user_sex) {
        this.user_sex = user_sex;
    }
}
