package Object_Oriented.封装重载值传递;
// 构造器的使用

/**
 * 构造器的作用：
 *      创建对象
 *      初始化对象的信息
 * 说明：
 *      若没有显式的定义类的构造器，则系统默认提供一个空参的构造器
 *      定义构造器的格式：权限修饰符 类名（形参列表）{}
 *      一个类中定义多个构造器，彼此构成重载
 *      一旦我们显式的定义了类的构造器后，系统就不在提供默认的空参构造器
 */
public class 构造器 {
    public static void main(String[] args) {
        Person p = new Person();
        Person p1 = new Person("tom",18);
        System.out.println(p1.name+"\t\t"+p1.age);
    }
}

class Person{
    String name;
    int age;

//    构造器
    public Person(){
        System.out.println("Use Person()");
    }
    public Person(String n,int a){
        name = n;
        age = a;

    }
    public void eat()
    {
        System.out.println("eat");
    }
}
