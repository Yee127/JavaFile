package JdbcTemplate.testDemo;

import JdbcTemplate.bean.Book;
import JdbcTemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class testDao {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook(new Book("30","AAAA","bbb",new BigDecimal("999"),"444","2222"));
//        bookService.showCount();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
//        bookService.addBook(new Book("30","AAAA","bbb",new BigDecimal("999"),"444","2222"));
        bookService.showCount();
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
//        bookService.addBook(new Book("30","AAAA","bbb",new BigDecimal("999"),"444","2222"));
//        bookService.showCount();
        bookService.showBook("1");


    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
//        bookService.addBook(new Book("30","AAAA","bbb",new BigDecimal("999"),"444","2222"));
//        bookService.showCount();
//        bookService.showBook("1");
        bookService.selectAll();


    }
/**
 * 批量测试
 */

    @Test
    public void testBatch(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {"27","HJHJHJ","fdfdf","4343","4343","333"};
        Object[] o2 = {"28","HJjhjh","fdfddf","443","4343","333"};
        Object[] o3 = {"29","HJHJHJ","ffdfdf","43","4343","333"};
        Object[] o4 = {"31","HJli","fd","403","4","3"};
        args.add(o1);
        args.add(o2);
        args.add(o3);
        args.add(o4);
        bookService.batchAddBook(args);


    }
}
