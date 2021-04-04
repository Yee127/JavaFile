package 练习;

import JDBC_Connection.JDBC_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
//        1.添加信息
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入Type:");
        int type = scanner.nextInt();
        System.out.print("输入IDCard:");
        String idCard = scanner.next();
        System.out.print("输入ExamCard:");
        String examCard = scanner.next();
        System.out.print("输入StudentName:");
        String studentName = scanner.next();
        System.out.print("输入Location:");
        String location = scanner.next();
        System.out.print("输入Grade:");
        int grade = scanner.nextInt();
        String sql = "insert into examstudent(Type, IDCard, ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
        int insertData = update(sql,type, idCard, examCard,studentName,location,grade);
        if(insertData > 0){
            System.out.println("添加成功");

        }else{
            System.out.println("添加失败");
        }

    }
//  通用增删改
    public static int update(String sql,Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBC_Connection.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i =0;i<args.length;i++){
                //填充占位符
                ps.setObject(i+1,args[i]);
            }
            // 4.执行
            /*
             * ps.execute():
             * 如果执行的是查询操作，有返回结果，则此方法返回true;
             * 如果执行的是增、删、改操作，没有返回结果，则此方法返回false.
             */
            //方式一：
//			return ps.execute();
            //方式二：
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC_Connection.closeResourse(connection,ps,null);
        }
        return 0;
    }
}
