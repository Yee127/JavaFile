package Object_Oriented.super关键字;
/**
 * super就是在子类调用父类属性，方法，构造器
 * this 就是当前子类的属性等等
 *
 *
 * super调用构造器：
 *       super(XXX)的使用。必须声明在子类构造器首行
 */


public class SuperTest {
    public static void main(String[] args) {
        Son s = new Son("嘻嘻嘻",9999);

        s.show();
    }
}
