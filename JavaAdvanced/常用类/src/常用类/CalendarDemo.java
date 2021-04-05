package 常用类;
import java.util.Calendar;
/*
    Calendar为某一-时刻和一 组日历字段之间的转换提供了一些方法，并为操作日历字段提供了一些方法
    Calendar提供了一个类方法getInstance 用于获取Calendar 对象，其日历字段已使用当前日期和时间初始化:
    Calendar rightNow = Calendar. getInstance();
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH)+1;
//        int date = calendar.get(Calendar.DATE);
//        System.out.println(year+"年"+month+"月"+date+"日");

        //public abstract void add (int field, int amount) :根据日历的规则，将指定的时间加减
        calendar.add(Calendar.YEAR,-3);//年-3
        calendar.add(Calendar.DATE,-3);//日-3
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH)+1;
//        int date = calendar.get(Calendar.DATE);
//        System.out.println(year+"年"+month+"月"+date+"日");
        //public final void set (int year, int month, int date):设置当前日历的年月日
        calendar.set(2055,11,11);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        System.out.println(year+"年"+month+"月"+date+"日");
    }
}
