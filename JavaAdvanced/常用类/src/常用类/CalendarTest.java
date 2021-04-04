package 常用类;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入年份：");
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
//        设置日历对象的年月日
        calendar.set(year,2,1);
//        3.1前一天就是2月的最后一天 即2月的天数
        calendar.add(Calendar.DATE,-1);
//        获取2月最后一天
        int date = calendar.get(Calendar.DATE);
        System.out.println(year+"年的二月份有"+date+"天");


    }
}
