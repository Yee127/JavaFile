package 练习;

import JDBC_Connection.JDBC_Connection;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("学生信息查询");
        System.out.println("a:准考证号");
        System.out.println("b.身份证号");
        System.out.print("请选择您要输入的类型：");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        switch (input){
            case "a":
                System.out.print("请输入准考证号：");
                String examCard = scanner.next();
                String sql1 = "select FlowID flowID,Type type, IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where ExamCard = ?";
                ExamStudent examstudent = getInstance(ExamStudent.class, sql1, examCard);
                if (examstudent != null){
                    System.out.println(examstudent);
                }else System.out.println("查无此人，请重新输入.....");
                break;
            case "b":
                System.out.print("请输入身份证号：");
                String IDCard = scanner.next();
                String sql2 = "select FlowID flowID,Type type, IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where IDCard = ?";
                ExamStudent examStudent1 = getInstance(ExamStudent.class, sql2, IDCard);
                if (examStudent1 != null){
                    System.out.println(examStudent1);
                }else System.out.println("查无此人，请重新输入.....");
                break;
            default: System.out.println("输入有误！！！\n 请重新输入......");break;
        }
    }
    //通用查询
    public static <T> T getInstance(Class<T> clazz,String sql,Object...args){
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
}
