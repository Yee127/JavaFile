package JdbcTemplate.dao;

import JdbcTemplate.bean.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);
    void update(Book book);
    void delete(String id);

//    查询

    /**
     * 查询记录数
     */
    void selectCount();

    Book selectBook(String id);

    List<Book> queryAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> args);
}
