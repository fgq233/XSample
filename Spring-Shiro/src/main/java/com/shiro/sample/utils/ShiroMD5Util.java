package com.shiro.sample.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class ShiroMD5Util {

    /**
     * shiro提供的MD5加密
     */
    public static String md5(String password){
        return new Md5Hash(password).toString();
    }

    /**
     * shiro提供的MD5加密、加盐
     */
    public static String md5Andsalt(String password){
        return new Md5Hash(password,"i_am_salt").toString();
    }

}