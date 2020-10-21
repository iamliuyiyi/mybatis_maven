package mapper;

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


public class TeacherMapperTest {

    // 获取日志记录器，将负责控制日志信息
    static Logger logger = Logger.getLogger(TeacherMapperTest.class);

    @Test
    public void getStudent1ById(){
        SqlSession session = MybatisUtils.getSqlSession();
        TeacherMapper tm = session.getMapper(TeacherMapper.class);
        System.out.println(tm.getStudent1ById(1));
        session.close();
    }



}
