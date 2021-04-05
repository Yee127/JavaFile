package Object_Oriented.内部类;

/**
 * 内部类：
 *      1.Java允许将一个类A声明在另一类B中   则A就是内部类 B为外部类
 *      2.内部类分类：成员内部类（静态 非静态） &  局部内部类
 *      3.成员内部类：
 *                  一方面：作为外部类的成员
 *                       》可以调用外部类的结构
 *                       》可以被Static修饰
 *                       》可被4种权限修饰
 *
 *                  另方面：作为一个类
 *                      》类内可定义属性、方法、构造器
 *                      》可以用final修饰，此类不可继承   言外之意：不用final则可以被继承
 *                      》可以被abstract修饰
 *
 * 关注3问题：
 *          1.如何实例化成员内部类的对象
 *          2.如何在成员内部类中区分调用外部类的结构
 *          3.开发局部内部类的使用
 */
public class InnerClass {
    public static void main(String[] args) {
//        创建Dog实例(静态的成员内部类)
      Person.Dog dog =  new Person.Dog();
      dog.run();
//      创建Pig实例（非静态的成员内部类）
        Person person = new Person();
        Person.Pig pig = person.new Pig();
    }

}


class Person{
    String name ;
    public void eat(){
        System.out.println("人 吃吃吃");
    }
//    成员内部类
    static class Dog{
        String name ;
        public void run(){
            System.out.println("狗  跑跑跑");
        }

    }

    class Pig{
        String name ;
        public void eat(){
            System.out.println("猪  吃吃吃");
            Person.this.eat();
        }

    }




}