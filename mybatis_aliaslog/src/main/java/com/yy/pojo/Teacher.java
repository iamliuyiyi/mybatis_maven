package com.yy.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author LYY
 * @Date 2020/10/20 14:51
 * @Version 1.0
 * @Title
 */
@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student1> studentList;  //一个老师拥有多个学生
}
