package com.yy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author LYY
 * @Date 2020/9/25 9:58
 * @Version 1.0
 * @Title
 */
//@Alias("stu")  //意思是存在student、Student、stu别名
@Data
@AllArgsConstructor  //所有参数的有参构造方法
@NoArgsConstructor   //无参构造方法
public class Student {
    private int id;
    private String name;
    private String sex;
    private String address;
    private Date birthday;


    public Student(String name, String sex, String address, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
    }
}
