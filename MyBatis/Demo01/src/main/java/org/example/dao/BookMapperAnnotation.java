package org.example.dao;

import org.apache.ibatis.annotations.Select;
import org.example.pojo.Book;

public interface BookMapperAnnotation {
    @Select("select * from t_book where id=#{id}")
    public Book selectBook(Integer id);
}
