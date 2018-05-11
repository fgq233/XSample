package com.xxx.mb.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 身份证------与User一对一
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Card {

    private Integer cid;
    private String cardNum;

    private User user;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
