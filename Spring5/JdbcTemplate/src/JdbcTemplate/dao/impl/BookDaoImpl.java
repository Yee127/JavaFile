package JdbcTemplate.dao.impl;




import JdbcTemplate.bean.Book;
import JdbcTemplate.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book) {
        String sql = "insert into t_book(id,name,author,price,sales,stock) values(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getSales(),book.getStock());
        System.out.println("记录："+ update);
    }

    @Override
    public void update(Book book) {


    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void selectCount() {
        String sql = "select count(*) from t_book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("总记录数："+ count);
    }

    @Override
    public Book selectBook(String id) {
        String sql = "select * from t_book where id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class),id);
        System.out.println(book.toString());
        return book;
    }

    @Override
    public List<Book> queryAllBook() {
        String sql = "select * from t_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));

        return bookList;
    }

    /**
     * 批量添加
     * @param batchArgs
     */
    @Override
    public void batchAddBook(List<Object[]> batchArgs){
        String sql = "insert into t_book(id,name,author,price,sales,stock) values(?,?,?,?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 批量修改
     * @param args
     */
    @Override
    public void batchUpdateBook(List<Object[]> args) {

    }
}
