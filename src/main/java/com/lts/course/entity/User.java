package com.lts.course.entity;

import org.springframework.util.StringUtils;

public class User {

    private Integer userId;

    private String userName;

    private String password;

    private String age;

    private String email;

    private String registerTime;

    /**
     * 用户名校验
     * @return boolean
     */
    public boolean checkUserName() {
        String usernameRegex = "^[a-zA-Z0-9_\\-\\u4e00-\\u9fa5\\\" \"]{6,32}$";
        return this.userName.matches(usernameRegex);
    }

    /**
     * 邮箱校验
     * @return boolean
     */
    public boolean checkEmail() {
        String emailRegix = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        boolean test = StringUtils.isEmpty(this.userName);
        return (StringUtils.isEmpty(this.email) || this.email.matches(emailRegix));
    }

    /**
     * 密码校验
     * @return boolean
     */
    public boolean checkPassword() {
        String pwRegex = "(?!.*[\\u4E00-\\u9FA5\\s])(?!^[a-zA-Z]+$)(?!^[\\d]+$)(?!^[^a-zA-Z\\d]+$)^.{8,16}$";
        return this.password.matches(pwRegex);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
}
