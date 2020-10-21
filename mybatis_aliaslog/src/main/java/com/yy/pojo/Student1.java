package com.yy.pojo;

import lombok.Data;

/**
 * @Author LYY
 * @Date 2020/10/20 14:49
 * @Version 1.0
 * @Title
 */
@Data
public class Student1 {
    private int id;
    private String name;
    private Teacher teacher;  // 老师
}
