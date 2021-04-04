package Object_Oriented.接口;

/**
 * JDK8   ：除了定义全局全局变量和抽象方法之外，还可以定义静态方法、默认方法等
 */

public class InterfaceStatic {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
//        接口中定义的静态方法只能通过接口来调用
        CompareA.method1();
//        通过实现类的对象 可以调用接口的默认方法
//        倘若实现类重写了接口中的默认方法 调用时 仍然调用的是重写以后的方法
        subClass.method2();
//        若子类（或是实现类）继承了父类和实现的接口中声明的同名同参数默认方法
//        则子类在没有重写此方法的情况下，默认调用的是父类的同名同参数方法>>>类优先原则
        subClass.method3();
//        如果实现类实现了多个接口 二这多少个接口定义了同名同伴的默认方法，
//        那么在实现类没有重写此方法的情况下 报错  >>>>>接口冲突
//        因此 必须在实现类中重写此方法

    }
}


interface CompareA{
    //静态方法
    public static void method1(){
        System.out.println("CompareA 1");
    }
    //默认方法
    public default void method2(){
        System.out.println("CompareA 2");
    }
    default void method3(){
        System.out.println("compareA 3");
    }
}
interface CompareB{
    default void method3(){
        System.out.println("compareB 3");
    }
}
class SubClass extends Father implements CompareA,CompareB{
    public void method2(){
        System.out.println("SubClass");
    }

}

class Father{
    public void method3(){
        System.out.println("Father method3 ");
    }
}