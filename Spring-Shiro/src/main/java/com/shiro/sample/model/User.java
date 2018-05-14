package com.shiro.sample.model;

public class User {

    private Integer uid;
    private String username;
    private String password;
    private boolean isRememberme;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberme() {
        return isRememberme;
    }

    public void setRememberme(boolean rememberme) {
        isRememberme = rememberme;
    }
}
