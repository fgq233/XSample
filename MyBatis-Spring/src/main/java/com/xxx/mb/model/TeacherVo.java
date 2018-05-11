package com.xxx.mb.model;

import java.io.Serializable;

public class TeacherVo implements Serializable {


    private Integer[] ids;

    private Teacher teacher;


    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
