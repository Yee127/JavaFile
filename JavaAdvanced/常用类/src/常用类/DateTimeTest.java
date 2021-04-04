package 常用类;

import org.junit.Test;

import java.util.Date;

/**
 * toString()显示年月日时分秒
 * getTime()获取当前Date对象对应的毫秒数（时间戳）
 */
public class DateTimeTest {
  @Test
  public void test(){
//      构造器1：Date（） 创建一个对应当前时间的Date对象
      Date date =new Date();

      System.out.println(date.toString());
      System.out.println(date.getTime());
//      构造器2：创建指定毫秒数的Date对象
      Date date1 = new Date(1604840505495L);
      System.out.println(date1.toString());
  }
}
