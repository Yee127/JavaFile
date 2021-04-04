package com.book.Test;

import com.book.Pojo.Book;
import com.book.Service.BookService;
import com.book.Service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    void addBook() {
        bookService.addBook(new Book(null,"阿巴阿巴","神来之笔",new BigDecimal(999999),99999999,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"社会我国哥，人狠话不多！", "1125", new BigDecimal(999999), 10, 111110, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}