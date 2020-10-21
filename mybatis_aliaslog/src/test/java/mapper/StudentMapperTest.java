package mapper;

import com.yy.mapper.StudentMapper;
import com.yy.pojo.Student;
import com.yy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

import org.apache.log4j.Logger;

import javax.annotation.Resource;

/**
 * @Author LYY
 * @Date 2020/9/25 21:27
 * @Version 1.0
 * @Title
 */


public class StudentMapperTest {

    // 获取日志记录器，将负责控制日志信息
    static Logger logger = Logger.getLogger(StudentMapperTest.class);

//    @Resource
//    StudentMapper studentMapper;

    /*
    分页：
    1、查出全部数据，返回一个list，然后根据前端传的参数再截取  数据量大就GG
    2、使用limit a,b    a：开始的下标，从0开始    b取多少条
    */
    @Test
    public void getList() {
        logger.info("=============这是log4j=========");
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取StudentMapper的代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int currPage = 2;  // 页码
        int pageSize = 20;  //一页多少条
        int currPage1 = (currPage - 1) * pageSize;
        // 执行StudentMapper中的方法
        List<Student> list = mapper.getList(currPage1, pageSize);
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

    // 多条件模糊查询
    @Test
    public void getListByQuery() {
        HashMap<String, String> map = new HashMap<>();
//        map.put("name", "子");
        map.put("address", "清水");
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        List<Student> list = sm.getListByQuery(map);
        for (Student student : list) {
            System.out.println(student);
        }
        session.close();
    }


//    @Test
//    public void add() {
//        Student student = new Student("aa", "男", "广州市", new Date());
//        SqlSession session = MybatisUtils.getSqlSession();
//        StudentMapper sm = session.getMapper(StudentMapper.class);
//        sm.add(student);
//        session.commit();  // 提交事务
//        session.close();  // 关闭连接
//    }

    @Test
    public void updateById() {
        Student student = new Student(17, "陈奕迅", "惠州市");
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        sm.updateById(student);
        session.commit();
        session.close();
    }

    @Test
    public void updateByMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "小言");
        map.put("address", "湘潭市");
        map.put("sex", "女");
        map.put("id", "17");
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        sm.updateByMap(map);
        session.commit();
        session.close();
    }

    @Test
    public void getListByAddress() {
        List<String> list = new ArrayList<>();
        list.add("惠州市");
        list.add("广州市");
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        List<Student> students = sm.getListByAddress(list);
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }

    @Test
    public void add1() {
        Student stu1 = new Student("海绵宝宝", "男", "比基尼海滩裤头村", new Date());
        Student stu2 = new Student("派大星", "男", "比基尼海滩裤头村", new Date());
//        Student stu3 = new Student("章鱼哥",new Date());
        ArrayList<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
//        list.add(stu3);
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        sm.add(list);
        session.commit();
        session.close();
    }


}
