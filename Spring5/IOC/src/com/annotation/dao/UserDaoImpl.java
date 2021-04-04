package com.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void update() {
        System.out.println("update -------");
    }
}
