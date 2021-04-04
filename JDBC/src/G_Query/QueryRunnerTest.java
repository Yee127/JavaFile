package G_Query;

import JDBCUtils.JDBCUtils;
import JDBC_Bean.Customers;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class QueryRunnerTest {
// 测试删除
    @Test
    public void testInsert(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnectionOfDruid();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            int insertCount = runner.update(conn, sql, "Rose", "rose@126.com", "1999-09-09");
            System.out.println(insertCount);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn,null);
        }
    }
    //测试查询
    /*
     * BeanHander:是ResultSetHandler接口的实现类，用于封装表中的一条记录。
     */
    @Test
    public void testQuery() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnectionOfDruid();
            String sql = "select * from customers where id = ?";
            BeanHandler<Customers> handler = new BeanHandler<>(Customers.class);
            Customers customers = runner.query(conn, sql, handler, 23);
            System.out.println(customers);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn,null);
        }

    }


	/*
	 * BeanListHandler:是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合

	 */
    @Test
    public void testQuery2() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnectionOfDruid();
            String sql = "select * from customers where id < ?";
            BeanListHandler<Customers> handler = new BeanListHandler<>(Customers.class);
            List<Customers> list = runner.query(conn, sql, handler, 23);
            list.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn,null);
        }

    }

    /*
     * MapHander:是ResultSetHandler接口的实现类，对应表中的一条记录。
     * 将字段及相应字段的值作为map中的key和value
     */
    @Test
    public void testQuery3(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnectionOfDruid();
            String sql = "select id,name,email,birth from customers where id = ?";
            MapHandler handler = new MapHandler();
            Map<String, Object> map = runner.query(conn, sql, handler, 23);
            System.out.println(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResourse(conn, null);

        }

    }

    /*
     * MapListHander:是ResultSetHandler接口的实现类，对应表中的多条记录。
     * 将字段及相应字段的值作为map中的key和value。将这些map添加到List中
     */
    @Test
    public void testQuery4(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnectionOfDruid();
            String sql = "select id,name,email,birth from customers where id < ?";

            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> list = runner.query(conn, sql, handler, 23);
            list.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResourse(conn, null);

        }

    }
    /*
     * ScalarHandler:用于查询特殊值
     */
    @Test
    public void testQuery5(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnectionOfDruid();

            String sql = "select count(*) from customers";

            ScalarHandler handler = new ScalarHandler();

            Long count = (Long) runner.query(conn, sql, handler);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResourse(conn, null);

        }

    }
    @Test
    public void testQuery6(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnectionOfDruid();

            String sql = "select max(birth) from customers";

            ScalarHandler handler = new ScalarHandler();
            Date maxBirth = (Date) runner.query(conn, sql, handler);
            System.out.println(maxBirth);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResourse(conn, null);
        }

    }
}
