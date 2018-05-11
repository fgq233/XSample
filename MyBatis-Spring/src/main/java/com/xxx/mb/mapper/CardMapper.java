package com.xxx.mb.mapper;

import com.xxx.mb.model.Card;
import com.xxx.mb.model.Teacher;
import com.xxx.mb.model.TeacherVo;
import com.xxx.mb.model.User;

import java.util.List;

public interface CardMapper {


    List<Card> findUserAndCard();

}
