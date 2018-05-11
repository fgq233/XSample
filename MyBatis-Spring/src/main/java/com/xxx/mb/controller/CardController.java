package com.xxx.mb.controller;

import com.xxx.mb.mapper.CardMapper;
import com.xxx.mb.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CardController {

    @Autowired
    private CardMapper cardlMapper;


    @RequestMapping("/queryUserCard")  //  一对一查询
    @ResponseBody
    public List<Card> query() {
        return cardlMapper.findUserAndCard();
    }


}
