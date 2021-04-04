package B_PreparedStatement;

import JDBC_Connection.JDBC_Connection;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PreparedStatementTest {
    @Test
    public void test1(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);

            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

//        2.加载驱动
            Class.forName(driverClass);
//          获取连接
            connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);
            String sql = "insert into customers(name,email,birth) values(?,?,?)";  //  ?: 占位符
            ps = connection.prepareStatement(sql);
//        填充占位符
            ps.setString(1,"马保国");
            ps.setString(2,"mbg@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1777-11-11");
            ps.setDate(3,new Date(date.getTime()));
//      执行sql操作
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {//        资源关闭
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }



    }


    @Test
    public void updateTest() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1.getConnection
            connection = JDBC_Connection.getConnection();
            //2.预编译sql语句，犯规PreparedStatement的实例
            String sql = "update customers set name=? where id =?";
            ps = connection.prepareStatement(sql);
            //3.填充占位符
            ps.setObject(1,"龟孙");
            ps.setObject(2,18);
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源关闭
            JDBC_Connection.closeResourse(connection,ps);
        }

    }


//    通用增删改
    public void update(String sql,Object ...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBC_Connection.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC_Connection.closeResourse(connection,ps);
        }

    }

    @Test
    public void generalTest(){
        String sql = "update customers set name=? where id =? ";
        update(sql,"阿巴阿巴",3);
    }

}
