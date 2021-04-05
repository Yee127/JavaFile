package org.example.dao;

import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public User selectUser(Integer id);

    public Integer add(User user);
    public Integer update(User user);
    public Integer delete(Integer id);


    public List<User> allUsers(Map<String,Object> map);
    public List<User> limitUsers(Map<String,Integer> map);
}
