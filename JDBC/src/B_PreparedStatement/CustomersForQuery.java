package B_PreparedStatement;

import JDBC_Bean.Customers;
import JDBC_Connection.JDBC_Connection;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class CustomersForQuery {

    @Test
    public void QueryTest(){
        String sql = "select id,name,birth,email from customers where id = ?";
        Customers customers = queryForCustomers(sql, 13);
        System.out.println(customers);
    }

    /**
     *  @Description 针对于customers表的通用的查询操作
     * @param sql
     * @param args
     * @return
     */
    public Customers queryForCustomers(String sql,Object...args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBC_Connection.getConnection();
            ps = connection.prepareStatement(sql);
            //填充字符集
            for (int i = 0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()){
                Customers customers = new Customers();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i<columnCount;i++){
                    //获取列值
                    Object columValue = rs.getObject(i + 1);
                    //获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给cust对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = Customers.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(customers, columValue);
                }

                return customers;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC_Connection.closeResourse(connection,ps,rs);
        }
        return null;
    }
}
