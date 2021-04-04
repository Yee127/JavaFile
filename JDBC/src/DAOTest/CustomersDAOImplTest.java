package DAOTest;

import JDBC_Bean.Customers;
import JDBC_Connection.JDBC_Connection;
import org.junit.Test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class CustomersDAOImplTest {
    private CustomerDAOImpl dao = new CustomerDAOImpl();

    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            conn = JDBC_Connection.getConnection();
            Customers cust = new Customers(1, "于小飞", "xiaofei@126.com",new Date(43534646435L));
            dao.insert(conn, cust);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBC_Connection.closeResourse(conn, null);

        }

    }

    @Test
    public void testDeleteById() {
        Connection conn = null;
        try {
            conn = JDBC_Connection.getConnection();

            dao.deleteById(conn, 13);


            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBC_Connection.closeResourse(conn, null);

        }
    }

    @Test
    public void testUpdateConnectionCustomer() {
        Connection conn = null;
        try {
            conn = JDBC_Connection.getConnection();
            Customers cust = new Customers(18,"贝多芬","beiduofen@126.com",new Date(453465656L));
            dao.update(conn, cust);


            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBC_Connection.closeResourse(conn, null);

        }
    }

    @Test
    public void testGetCustomerById() {
        Connection conn = null;
        try {
            conn =JDBC_Connection.getConnection();
            Customers cust = dao.getCustomerById(conn, 19);
            System.out.println(cust);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBC_Connection.closeResourse(conn, null);
        }
    }

    @Test
    public void testGetAll() {
        Connection conn = null;
        try {
            conn = JDBC_Connection.getConnection();

            List<Customers> list = dao.getAll(conn);
            list.forEach(System.out::println);


            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBC_Connection.closeResourse(conn, null);

        }
    }

    @Test
    public void testGetCount() {
        Connection conn = null;
        try {
            conn = JDBC_Connection.getConnection();

            Long count = dao.getCount(conn);

            System.out.println("表中的记录数为：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBC_Connection.closeResourse(conn, null);

        }
    }

    @Test
    public void testGetMaxBirth() {
        Connection conn = null;
        try {
            conn = JDBC_Connection.getConnection();

            Date maxBirth = dao.getMaxBirth(conn);

            System.out.println("最大的生日为：" + maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBC_Connection.closeResourse(conn, null);

        }
    }
}
