package com.xxx.mb.controller;

import com.xxx.mb.mapper.TeacherMapper;
import com.xxx.mb.mapper.UserMapper;
import com.xxx.mb.model.Teacher;
import com.xxx.mb.model.TeacherVo;
import com.xxx.mb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherMapper teacherMapper;


    @RequestMapping("/queryTeacher1/{tid}")  //  查1:属性名与表中字段名不一致时，需要手动映射
    @ResponseBody
    public Teacher query(@PathVariable("tid") Integer tid) {
        Teacher teacher = teacherMapper.findTeacherById(tid);
        return teacher;
    }


    @RequestMapping("/queryTeacher2/{tAge}/{tName}")  //  查2:属性名与表中字段名不一致时，需要手动映射
    @ResponseBody
    public List<Teacher> query(@PathVariable("tAge") Integer tAge, @PathVariable("tName") String tName) {
        Teacher teacher = new Teacher();
        teacher.settAge(tAge);
        teacher.settName(tName);
        List<Teacher> list = teacherMapper.findTeacherByNameAndAge(teacher);
        return list;
    }

    @RequestMapping("/queryTeacher3")  //  查3: foreach遍历多个查询条件
    @ResponseBody
    public List<Teacher> query() {
        TeacherVo vo = new TeacherVo();
        Integer [] ids = {1,2,3};
        vo.setIds(ids);
        List<Teacher> list = teacherMapper.findTeacherByIds(vo);
        return list;
    }


    @RequestMapping("/insertTeacher")  //  增：传参之包装类
    @ResponseBody
    public String insert() {
        TeacherVo vo = new TeacherVo();
        Teacher t = new Teacher();
        t.settName("baby");
        t.settAddress("China");
        t.settAge(18);
        vo.setTeacher(t);
        teacherMapper.insertTeacher(vo);
        return "sucess";
    }


}
