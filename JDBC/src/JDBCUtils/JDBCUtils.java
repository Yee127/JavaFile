package JDBCUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
/**
 * 操作数据库的工具类
 */
        public static Connection getConnection() throws Exception {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);

            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

//        2.加载驱动
            Class.forName(driverClass);

            Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);
            return connection;
        }

    /**
     * 使用德鲁伊数据库连接池
     *
     */
        private static DataSource source;
        static {
            try {
                Properties pros = new Properties();
                InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Druid.properties");
                pros.load(is);
                source = DruidDataSourceFactory.createDataSource(pros);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static Connection getConnectionOfDruid() throws SQLException {
            Connection connection = source.getConnection();
            return connection;
        }
    /**
         * 连接关闭操作
         * @param connection
         * @param ps
         */
        public static void closeResourse(Connection connection, Statement ps){
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

        /**
         * 关闭资源操作
         * @param connection
         * @param ps
         * @param rs
         */
        public static void closeResourse(Connection connection, Statement ps, ResultSet rs){
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
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        public static void closeResourseOfDbutils(Connection connection, Statement ps, ResultSet rs){
            DbUtils.closeQuietly(connection);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(rs);
        }
}
