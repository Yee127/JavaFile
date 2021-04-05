package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.BookMapper;
import org.example.dao.BookMapperAnnotation;
import org.example.pojo.Book;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

public class test01 {
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
    public void testAdd(){
//        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
//            获取结口的实现类对象
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
//            Book book = mapper.selectBook(1);

            mapper.add(new Book(32, "ABCD", "AA", new BigDecimal(99), 999, 9));
            System.out.println("success....");

        } finally {
            sqlSession.close();
        }


    }
    @Test
    public void testSelect02(){
//        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
//            Book book = sqlSession.selectOne("org.example.dao.BookMapper.selectBook", 1);
//            获取结口的实现类对象
            BookMapperAnnotation mapper = sqlSession.getMapper(BookMapperAnnotation.class);
            Book book = mapper.selectBook(1);
            System.out.println(book);
        } finally {
            sqlSession.close();
        }


    }
    @Test
    public void testSelect01(){
//        获取getSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
//            Book book = sqlSession.selectOne("org.example.dao.BookMapper.selectBook", 1);
//            获取结口的实现类对象
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            Book book = mapper.selectBook(1);
            System.out.println(book);
        } finally {
            sqlSession.close();
        }


    }
}
