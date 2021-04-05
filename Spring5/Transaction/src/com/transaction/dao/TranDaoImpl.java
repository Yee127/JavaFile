package com.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TranDaoImpl implements TranDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void reduce() {
        String sql = "update tran set balance=balance-? where name=?  ";
        jdbcTemplate.update(sql,100,"Tom");

    }
    @Override
    public void increase() {
        String sql = "update tran set balance=balance+? where name=?  ";
        jdbcTemplate.update(sql, 100, "Mike");

    }


}
