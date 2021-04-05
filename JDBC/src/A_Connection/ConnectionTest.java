package A_Connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
//   方式一：
    @Test
    public void testConnection1() throws SQLException {
//        获取Driver实现类对象
        Driver driver = new com.mysql.cj.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";
//        将用户名和密码封装到Properties中
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","Van0127/");
        Connection connection = driver.connect(url,info);
        System.out.println(connection);

    }
//   方式二：
//    对方式一的迭代：在如下的程序中不出现第三方的api，使得程序具有更好的移植性
    @Test
    public void test2() throws Exception {
//        1.获取Driver实现类对象，使用反射
        Class aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver =(Driver) aClass.newInstance();
//        2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";
//        3.将用户名和密码封装到Properties中
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","Van0127/");
//        4.获取连接
        Connection connection = driver.connect(url,info);
        System.out.println(connection);
    }
//   方式三：使用DriverManager替换Driver

    @Test
    public void test3() throws Exception {
//        1.获取Driver实现类对象，使用反射
        Class aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver =(Driver) aClass.newInstance();
//        2.提供三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String passward = "Van0127/";
//        3.注册驱动
        DriverManager.registerDriver(driver);
//        4.获取连接
        Connection connection = DriverManager.getConnection(url, user, passward);
        System.out.println(connection);
    }
//   方式四：优化方式三：使用DriverManager替换Driver
@Test
public void test4() throws Exception {
//        1.提供三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String passward = "Van0127/";
//        2.加载Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
//    Driver driver =(Driver) aClass.newInstance();
//
////        3.注册驱动
//    DriverManager.registerDriver(driver);
//        4.获取连接
        Connection connection = DriverManager.getConnection(url, user, passward);
        System.out.println(connection);
    }
//   方式五：最终️
//将数据库连接的四个基本数据信息声明在配置文件中，通过读取配置文件获取连接
    @Test
    public void getConnection() throws Exception {
//读取配置文件的四个基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

//        2.加载驱动
        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
