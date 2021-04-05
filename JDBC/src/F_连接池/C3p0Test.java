package F_连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Test {
    @Test
    public void test() throws PropertyVetoException {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
            cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
            cpds.setUser("root");
            cpds.setPassword("Van0127/");
            cpds.setInitialPoolSize(10);
            System.out.println(cpds);
    }
    @Test    // 使用配置文件的方式
    public void test2() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);

    }
}
