package DAOTest;

import JDBC_Bean.Customers;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/*
 * 此接口用于规范针对于customers表的常用操作
 */
public interface CustomersDAO {
    /**
     * @Description 将cust对象添加到数据库中
     */
    void insert(Connection conn, Customers cust);
    /**
     *
     * @Description 针对指定的id，删除表中的一条记录
     * @author shkstart
     * @date 上午11:01:07
     * @param conn
     * @param id
     */
    void deleteById(Connection conn,int id);
    /**
     *
     * @Description 针对内存中的cust对象，去修改数据表中指定的记录
     * @author shkstart
     * @date 上午11:02:14
     * @param conn
     * @param cust
     */
    void update(Connection conn,Customers cust);
    /**
     *
     * @Description 针对指定的id查询得到对应的Customer对象
     * @author shkstart
     * @date 上午11:02:59
     * @param conn
     * @param id
     */
    Customers getCustomerById(Connection conn,int id);
    /**
     *
     * @Description 查询表中的所有记录构成的集合
     * @author shkstart
     * @date 上午11:03:50
     * @param conn
     * @return
     */
    List<Customers> getAll(Connection conn);
    /**
     *
     * @Description 返回数据表中的数据的条目数
     * @author shkstart
     * @date 上午11:04:44
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

    /**
     *
     * @Description 返回数据表中最大的生日
     * @author shkstart
     * @date 上午11:05:33
     * @param conn
     * @return
     */
    Date getMaxBirth(Connection conn);
}
