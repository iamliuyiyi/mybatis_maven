package mapper;

import com.yy.mapper.Student1Mapper;
import com.yy.mapper.TeacherMapper;
import com.yy.pojo.Student1;
import com.yy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @Author LYY
 * @Date 2020/9/25 21:27
 * @Version 1.0
 * @Title
 */


public class Student1MapperTest {

    // 获取日志记录器，将负责控制日志信息
    static Logger logger = Logger.getLogger(Student1MapperTest.class);

    @Test
    public void getList() {
        SqlSession session = MybatisUtils.getSqlSession();
        Student1Mapper sm = session.getMapper(Student1Mapper.class);
        List<Student1> list = sm.getStudentListByTeacherId();
        for (Student1 student : list) {
            System.out.println(student.toString());
        }
        session.close();
    }


}
