package mapper;

import com.yy.mapper.StudentMapper;
import com.yy.pojo.Student;
import com.yy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @Author LYY
 * @Date 2020/9/25 21:27
 * @Version 1.0
 * @Title
 */

public class StudentMapperTest {

    // 获取日志记录器，将负责控制日志信息
    static Logger logger = Logger.getLogger(StudentMapperTest.class);

    @Test
    public void getList() {
        logger.info("=============这是log4j=========");
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取StudentMapper的代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        // 执行StudentMapper中的方法
        List<Student> list = mapper.getList();
        for (Student student : list) {
            System.out.println(student.toString());
        }
        sqlSession.close();
    }

    @Test
    public void getStudentById() {
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        Student name = sm.getStudentById(1);
        System.out.println(name);
        session.close();
    }

    // 模糊查询
    @Test
    public void getListByName() {
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        List<Student> list = sm.getListByName("子");
//        List<Student> list = sm.getListByName("1 or 1=1");
        for (Student student : list) {
            System.out.println(student.toString());
        }
        session.close();
    }


    @Test
    public void add() {
        Student student = new Student("aa", "男", "广州市", new Date());
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        sm.add(student);
        session.commit();  // 提交事务
        session.close();  // 关闭连接
    }

    @Test
    public void updateById() {
        Student student = new Student(17,"小新", "男", "惠州市", new Date());
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        sm.updateById(student);
        session.commit();
        session.close();
    }

    @Test
    public void updateByMap() {
        HashMap<String,String> map = new HashMap<>();
        map.put("name","小言");
        map.put("address","湘潭市");
        map.put("sex","女");
        map.put("id","17");
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        sm.updateByMap(map);
        session.commit();
        session.close();
    }


}
