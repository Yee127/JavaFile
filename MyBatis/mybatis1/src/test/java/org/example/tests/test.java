package org.example.tests;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.example.dao.UserMapper;
import org.example.dao.UserMapperAnnotation;
import org.example.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static Logger logger = Logger.getLogger(test.class);
    public SqlSessionFactory getSqlSessionFactory(){
        InputStream inputStream = null;
        try {
            String resource = "mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void Test_limit(){
        //        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            int currentPage = 1;
            int pageSize =2;
            Map<String, Integer> map = new HashMap<>();
            map.put("startIndex",(currentPage-1)*pageSize);
            map.put("pageSize",pageSize);

            List<User> users = mapper.limitUsers(map);
            for (User user:users) {
                System.out.println(user);
            }
        }finally {
            session.close();
        }
    }
//    指定字段查询
    @Test
    public void Test_selectList(){
        //        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("username","老二");
            map.put("pwd","laoer");
            List<User> users = mapper.allUsers(map);
            for (User user:users) {
                System.out.println(user);
            }
        }finally {
            session.close();
        }
    }
    @Test
    public void Test_Log(){
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        //        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(2);
            System.out.println(user);
        }finally {
            session.close();
        }
    }
    @Test
    public void Test_update(){
        //        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            Integer user= mapper.update(new User(2, "老二", "laoer", "BeiJing", "1008611"));
            session.commit();
            System.out.println("Update：["+user+"]");
        }finally {
            session.close();
        }
    }
    @Test
    public void Test04_add(){
        //        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            Integer integer1 = mapper.add(new User(null, "newPerson", "1234", "HK", "12309098787"));
//            Integer integer2  = mapper.delete(1);
            session.commit();
            System.out.println("Add["+integer1+"] Successfully");
//            System.out.println("Delete:["+integer2+"] Successfully");
        }finally {
            session.close();
        }
    }
    @Test
    public void Test03() throws IOException {
        //        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapperAnnotation mapper = session.getMapper(UserMapperAnnotation.class);
            User user = mapper.selectUser(1);
            System.out.println(user);
        }
    }
    @Test
    public void Test02() throws IOException {
        //        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(2);
            System.out.println(user);
        }
    }
    @Test
    public void Test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = (User) session.selectOne("org.example.pojo.UserMapper.selectUser", 1);
            System.out.println(user);
        }
    }
}
