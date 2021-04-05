package 常用类;

import org.junit.Test;

/**
 *  1.String声明为final时不可被继承
 *  2.String实现了Serializable接口：表示字符串是支持序列化的
 *       实现了Comparable接口：表示String可比较大小
 *  3.String内部定义了final char[] value 用于存储字符串数据
 *  4.String代表不可变的字符序列，简称不可变性
 *        体现：1.当对于字符串重新赋值时，需要重新指定内存区域赋值，不可使用原有的
 *              value进行赋值
 *             2.当对现有字符串进行连接操作时，也需要需要重新指定内存区域赋值，不可使用原有的
 *               value进行赋值
 *             3.当调用String的replace()方法修改制定字符或字符串时，需要重新指定内存区域赋值，不可使用原有的
 *               value进行赋值
 *  5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
 *  6.字符串常量池中是不会存储相同内容的字符串的
 */
public class StringTest {

    @Test
    public void test1(){
        String s1 = "abc";//字面量定义方式
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1 == s2);//比较两者地址值
        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test2(){
//        通过字面量定义的方式：此时s1,s2的数据JavaEE声明在方法区的字符串常量池中
        String s1 = "JavaEE";
        String s2 = "JavaEE";
//        通过new + 构造器的方式 ： 此时 s3,s4保存的地址值，
//        时数据在对空间中开辟空间以后对应
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s1 == s2);

    }

    /**
     * 拼接:
     *      常量于常量的拼接结果在常量池。常量池中不会存在相同内容的常量
     *      只要其中有一个为变量，结果就在堆中
     *      如果拼接的结果调用intern()方法，返回值就在常量池中
     *
     *
     */
    @Test
    public void test3(){
        String s1 = "Hello";
        String s2 = "Word";

        String s3 = "HelloWord";
        String s4 = "Hello"+"Word";
        String s5 = s1 + "Word";
        String s6 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false

        String s7 = s4.intern();
        System.out.println(s7 == s4);//true


    }
}
