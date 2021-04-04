package org.example.dao;

import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

public interface UserMapperAnnotation {
    @Select(" select * from user where id = #{id}")
    public User selectUser(Integer id);
}
