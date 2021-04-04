package com.book.DAO.impl;

import com.book.Utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner =new QueryRunner();

    /**
     * update() 方法用来执行：Insert\Update\Delete语句
     *
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql,Object...args){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(connection,null,null);
        }
        return -1;
    }

    /**
     *  查询返回一个javaBean的sql语句
     *
     * @param T
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> T,String sql,Object...args){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<T>(T),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(connection,null,null);
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sql语句
     *
     * @param T
     * @param sql
     * @param args
     * @param <T>
     * @return
     */

    public <T> List<T> queryForList(Class<T> T, String sql, Object...args){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanListHandler<T>(T),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(connection,null,null);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args){

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection,sql,new ScalarHandler<>(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(connection,null,null);
        }
        return null;

    }
}
