package com.yy.mapper;

import com.yy.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author LYY
 * @Date 2020/9/25 10:01
 * @Version 1.0
 * @Title
 */
public interface StudentMapper {
    @Select("select * from student limit #{currPage}, #{pageSize};")
    List<Student> getList(@Param("currPage") int currPage,@Param("pageSize") int pageSize);

    @Select("select * from student where id = #{id};")
    Student getStudentById(@Param("id") int id);



//    @Insert("insert into Student(name,sex,address,birthday) values(#{name},#{sex},#{address},#{birthday});")
//    void add(Student student);

    // 模糊查询
    @Select("select * from student where name like concat('%',#{name},'%');")
    List<Student> getListByName(@Param("name") String name);

    // 引用类型
//    @Update("update student set name = #{student.name},address= #{student.address} where id = #{student.id};")
    void updateById(@Param("student") Student student);

    //传入一个map对象
    @Update("update student set name = #{name},address= #{address} where id = #{id};")
    void updateByMap(HashMap<String,String> map);

    // 使用动态sql实现多条件查询
    List<Student> getListByQuery(HashMap map);

    // 通过多个address筛选
    List<Student> getListByAddress(List<String> list);

    // 批量插入
    void add(ArrayList<Student> list);


}
