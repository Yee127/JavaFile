package B_PreparedStatement;

import JDBC_Bean.Customers;
import JDBC_Connection.JDBC_Connection;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class GentleQuery {
    @Test
    public void test1(){
        String sql = "select id,name,email from customers where id = ?";
        Customers customer = getInstance(Customers.class,sql,12);
        System.out.println(customer);
    }
    /**
     *
     * @Description 使用PreparedStatement实现针对于不同表的通用的查询单个记录
     * @version
     * @date 上午11:32:55
     *
     */
    public <T> T getInstance(Class<T> clazz,String sql,Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBC_Connection.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()){
                T t = clazz.newInstance();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i<columnCount;i++){
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);
                    // 获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC_Connection.closeResourse(connection,ps,rs);
        }

        return null;

    }

    @Test
    public void test2(){
        String sql = "select id,name,email from customers where id < ?";
        List<Customers> list = getForList(Customers.class,sql,12);
        list.forEach(System.out::println);

    }
    /**
     * @Description 使用PreparedStatement实现针对于不同表的通用的查询多条记录
     * @return
     */

    public <T> ArrayList<T> getForList(Class<T> clazz, String sql, Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBC_Connection.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            ArrayList<T> list = new ArrayList<T>();
            while(rs.next()){
                T t = clazz.newInstance();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i<columnCount;i++){
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);
                    // 获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC_Connection.closeResourse(connection,ps,rs);
        }
        return null;

    }
}
