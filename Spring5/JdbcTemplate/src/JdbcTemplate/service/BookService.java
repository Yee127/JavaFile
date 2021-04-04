package JdbcTemplate.service;



import JdbcTemplate.bean.Book;
import JdbcTemplate.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.add(book);
    }

//   查询记录数
    public void showCount(){
        bookDao.selectCount();
    }

//    查询返回对象(图书)
    public void showBook(String id){
        bookDao.selectBook(id);
    }

//    查询所有图书
    public void selectAll(){
        List<Book> books = bookDao.queryAllBook();
        System.out.println(books);
    }

//    批量添加记录
    public void batchAddBook(List<Object[]> args){
        bookDao.batchAddBook(args);
    }

}
