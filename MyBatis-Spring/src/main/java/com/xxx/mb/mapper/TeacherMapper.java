package com.xxx.mb.mapper;

import com.xxx.mb.model.Teacher;
import com.xxx.mb.model.TeacherVo;
import com.xxx.mb.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {



    //  单个查询
    Teacher findTeacherById(Integer tid);


    //  单个查询
    List<Teacher> findTeacherByNameAndAge(Teacher teacher);


    //  foreach标签遍历多个查询条件
    //List<Teacher> findTeacherByIds(Integer[] ids);
    //List<Teacher> findTeacherByIds(List<Integer> ids);
    List<Teacher> findTeacherByIds(TeacherVo vo);


    //  插入
    void insertTeacher(TeacherVo vo);
}
