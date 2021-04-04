package Object_Oriented.接口;

public class Interface {
    public static void main(String[] args) {
        Plane plane = new Plane();
        plane.fly();

        Kite kite = new Kite();

    }
}

/**
 *
 * interface使用：接口和类是并列关系
 *
 *  Before JDK7：只能定义全局常量和抽象方法
 *               >全局常量：publice static final（书写时可以省略不写）
 *               >抽象方法：public abstract
 * After JDK8   ：除了定义全局全局变量和抽象方法之外，还可以定义静态方法、默认方法等
 *
 * 接口中 不可以定义构造器 接口不可以实例化
 *
 * 在Java开发中  接口通过让类去实现(implements)接口
 *              若 实现类覆盖了接口中所有的抽象方法，则此实现类可实例化，反之则仍为一个抽象类
 * Java类可以实现多个接口
 *      格式：
 *          class XX extends AAA implements Abb,Acc,Add
 * 接口与接口之间可继承，且可以多继承
 *
 * 接口具体使用；体现多态性
 * 接口，实际是可以看成一种规范
 */
interface Flyable{
    //全局常量
    public static final int Max_Speed = 7900;


//    抽象方法
    public abstract void fly();

    void stop();//省略了public abstract

}
interface Attackable{
    void attack();
}
class Plane implements Flyable{

    @Override
    public void stop() {
        System.out.println("通过引擎飞~");
    }

    @Override
    public void fly() {
        System.out.println("驾驶员减速");

    }
}

class Kite implements Flyable{
    @Override
    public void stop() {

    }

    @Override
    public void fly() {

    }
}
//实现多个接口
class Bullet extends Object implements Flyable,Attackable{
    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }
}

//接口多继承

interface AA{

}
interface BB{

}

interface CC extends AA,BB{

}