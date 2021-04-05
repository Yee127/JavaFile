package 常用类;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
构造方法:
    public SimpleDateFormat ():构造一个s impl eDateFormat,使用默认模式和日期格式
    public SimpleDateformat (String pattern) :构造一个SimpleDateFormat使用给定的模式和默认的日期格式
 格式化：从Date到String
    public final String format(Date date);将日期转为日期/时间字符串
 解析:从String 到 Date
    public Date parse(String source);从给定的字符串的开始解析文本以生成日期
 */
public class SimpleDataFormatDemo {
    public static void main(String[] args) throws ParseException {
//        格式化：从date 到 String
        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str = simpleDateFormat.format(date);
        System.out.println(str);
        System.out.println("___________________________");
//        解析：从String 到 Date
        String str1 = "2021-08-09 11:11:11";
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = simpleDateFormat2.parse(str1);
        System.out.println(date2);
    }

}
