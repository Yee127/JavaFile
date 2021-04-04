package B_PreparedStatement;

import JDBCUtils.JDBCUtils;
import JDBC_Bean.Customers;
import JDBC_Connection.JDBC_Connection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {
    @Test
    public void selectTest1()  {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //改用连接池
            connection = JDBCUtils.getConnectionOfDruid();
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,2);
            //执行并返回结果集
            resultSet = ps.executeQuery();
            //处理结果集
            if (resultSet.next()){//判断结果集下一条是否有数据，是返回TRUE 指针下移，
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

    //            Object [] data = new Object[]{id,name,email,birth};
                Customers customers = new Customers(id, name, email, birth);
                System.out.println(customers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBC_Connection.closeResourse(connection,ps,resultSet);
        }


    }
}
