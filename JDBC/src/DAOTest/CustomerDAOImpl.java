package DAOTest;

import JDBC_Bean.Customers;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class CustomerDAOImpl extends BaseDAO implements CustomersDAO{

    @Override
    public void insert(Connection conn, Customers cust) {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Customers cust) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }

    @Override
    public Customers getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customers customer = getInstance(conn,Customers.class, sql,id);
        return customer;
    }

    @Override
    public List<Customers> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customers> list = getForList(conn, Customers.class, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        return getValue(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from customers";
        return getValue(conn, sql);
    }
}
