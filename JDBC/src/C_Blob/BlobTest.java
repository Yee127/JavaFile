package C_Blob;

import JDBC_Bean.Customers;
import JDBC_Connection.JDBC_Connection;
import org.junit.Test;

import java.io.*;
import java.sql.*;

public class BlobTest {
//    插入blob
    @Test
    public void test1() throws Exception {
        Connection connection = JDBC_Connection.getConnection();
        String sql = "insert into customers(name,email,birth,photo)values (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setObject(1,"Google");
        ps.setObject(2,"google@gmail.com");
        ps.setObject(3,"1999-01-01");
        FileInputStream is = new FileInputStream(new File("src/google.png"));
        ps.setObject(4,is);
        ps.execute();
        JDBC_Connection.closeResourse(connection,ps);
    }

//    查询
    @Test
    public void test2() {
        FileOutputStream fos = null;
        InputStream is = null;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            fos = null;
            is = null;
            connection = JDBC_Connection.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id=?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,22);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customers customers = new Customers(id, name, email, birth);
                System.out.println(customers);

    //            将Blob类型的字段下载下来  以文件的方式保存下来
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("photo.png");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1){
                    fos.write(buffer,0,len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            JDBC_Connection.closeResourse(connection,ps);
           if (is != null){
               try {
                   is.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
