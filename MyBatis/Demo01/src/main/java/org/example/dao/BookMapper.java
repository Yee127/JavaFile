package org.example.dao;

import org.apache.ibatis.annotations.Select;
import org.example.pojo.Book;

public interface BookMapper {
    @Select("select * from t_book where id=#{id}")
    public Book selectBook(Integer id);

    public void add(Book book);
    public void delete(String id);
    public void update(Book book);


}
