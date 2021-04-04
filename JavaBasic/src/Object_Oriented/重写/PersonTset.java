package Object_Oriented.重写;

/**
 * 简言之：子类重写父类方法，但是不能重写父类private方法
 *        父类方法返回值类型是void，则子类必须也是void
 *        父类方法返回值类型是基本数据类型（eg：double），则子类必须也是相同的基本数据类型（double）
 *        父类返回值类型是其他的（假设A类型），则子类可以是A类或者A类的子类
 *        子类重写的方法不大于父类被重写的方法抛出的异常类型
 *
 *
 * 非static可以考虑重写 static的不是重写
 *
 *
 *
 */
public class PersonTset {
    public static void main(String[] args) {
        Student s = new Student("Computer");

        Person p = new Person();
        System.out.print("父类的： ");
        p.eat();
        System.out.print("子类重写父类的： ");
        s.eat();


    }
}
