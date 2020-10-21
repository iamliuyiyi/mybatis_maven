package com.yy.mapper;

import com.yy.pojo.Student1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LYY
 * @Date 2020/10/20 14:53
 * @Version 1.0
 * @Title
 */
public interface Student1Mapper {
    List<Student1> getStudentListByTeacherId();
}
