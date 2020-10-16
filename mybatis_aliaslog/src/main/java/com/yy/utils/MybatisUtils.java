package com.yy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author LYY
 * @Date 2020/10/9 12:15
 * @Version 1.0
 * @Title SQLSession可以当做是一个请求数据库的请求
 */
public class MybatisUtils {
    private static SqlSessionFactory builder;

    static {
        // 肯定要读取mybatis核心文件呀
        String resource = "mybatis-config.xml";
        InputStream is = null;
        try {
            // 注意：都是ibatis目录下的包
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建模式创建工厂
        builder = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSession getSqlSession() {
        // 工厂创建sqlsession
//        return builder.openSession(true);   true设置事务自动提交  默认需要手动提交session.commit();最好不要开启自动提交，sql错了就比较麻烦
        return builder.openSession();
    }
}
