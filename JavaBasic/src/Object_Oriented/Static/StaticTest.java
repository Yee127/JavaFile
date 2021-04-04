package Object_Oriented.Static;

/**
 * Static
 *      修饰：属性，方法，代码块，内部类
 *
 * 1.修饰属性：静态变量
 *          多个对象共享同一个静态变量。
 * 2.修饰方法：
 *          可通过  类.静态方法 调用
 *          静态方法中，只能调用静态的方法或者属性
 *          非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
 * 3.注意点：
 *          在静态的方法内，不能使用this、super关键字.
 *
 */

public class StaticTest {
    public static void main(String[] args) {
        Static s = new Static();
        s.A = 1;
        s.B = 2;
        System.out.println(s.A+"\t"+s.B);

        Static s1 = new Static();
        s1.A = 11;
//        s1.B = 22;
        System.out.println(s1.A+"\t"+s1.B);
        Static.show();
    }
}

class Static{
    int A = 1;
    static int B;

    public void info(){
        System.out.println("Info");
    }
    public static void show(){
        System.out.println("Show");
    }
}