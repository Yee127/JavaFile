package Class实例;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test{
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
//        1 通过反射创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object o = cons.newInstance("Tom", 12);
        Person p =(Person) o;
        System.out.println(p.toString());

        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("====================================");
//      通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"ABAB");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"China");
        System.out.println(nation);


    }


    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
    来获取此运行时类。
     */
    //获取Class的实例的方式（前三种方式需要掌握）

    @Test
    public void test2() throws ClassNotFoundException{
        //方式一：调用运行时类的属性：.class
        Class clazz = Person.class;
        System.out.println(clazz);


        //方式二：通过运行时类的对象,调用getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("Class实例.Person");
        System.out.println(clazz3);

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = test.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("Class实例.Person");
        System.out.println(clazz4);

        System.out.println(clazz == clazz4);
    }

    //Class实例可以是哪些结构的说明：
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }
}
