package com.yy.mapper;

import com.yy.pojo.Student1;
import com.yy.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LYY
 * @Date 2020/10/20 14:54
 * @Version 1.0
 * @Title
 */
public interface TeacherMapper {

    // 获取指定老师下的学生
    Teacher getStudent1ById(@Param("id") int id);
}
