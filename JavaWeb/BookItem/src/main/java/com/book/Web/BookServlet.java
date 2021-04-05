package com.book.Web;

import com.book.Pojo.Book;
import com.book.Pojo.Page;
import com.book.Service.BookService;
import com.book.Service.impl.BookServiceImpl;
import com.book.Utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{
    BookService bookService =new BookServiceImpl();
//查询所有图书
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过 BookService 查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到 Request 域中
        req.setAttribute("books",books);
        //3、请求转发到/pages/manager/book_manager.jsp 页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
//    添加图书
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

//        2、调用 BookService.addBook()保存图书
        bookService.addBook(book);
//        3、跳到图书列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

//    删除图书
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数 id，图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

//        2、调用 bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
//        3、重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }
//    获取图书信息
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         获取请求参数的图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        查询图书
        Book book = bookService.queryBookById(id);
//        保存到图书的request域中
        req.setAttribute("book",book);
//        请求转发到 pages/manager/book_edit.jsp 页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
//      修改
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
//        2、调用 BookService.updateBook( book );修改图书
        bookService.updateBook(book);
//        3、重定向回图书列表管理页面
//        地址:/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }
    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用 BookService.page(pageNo，pageSize):Page 对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //3 保存 Page 对象到 Request 域中
        req.setAttribute("page",page);
        //4 请求转发到 pages/manager/book_manager.jsp 页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
