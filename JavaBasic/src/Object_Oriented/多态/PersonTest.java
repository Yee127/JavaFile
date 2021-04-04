package Object_Oriented.多态;

/**
 * 多态性：
 *      1.理解： 一个事物的多种形态
 *      2.何为多态性：父类的引用指向子类的对象
 *      3.多态的使用：虚拟方法调用
 *                  有了对象的多态性后，只能调用父类声明的方法，
 *                  但在实际执行时是执行子类重写父类的方法
 *      4.多态性使用前提： 要有类的继承关系
 *                      要有方法的重写
 *      5.对象的多态性只适用于方法，不适用于属性
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        Man m = new Man();
        m.eat();
        m.earnMoney();

        System.out.println("[ 多 态 ]");
/*********************  多 态  **************************/

        /**多态性:父类的引用指向子类的对象*/
        Person p2 = new Man();
        Person p3 = new Woman();
//多态使用：
        p2.eat();
        p2.walk();//输出的是子类重写父类的方法 -- 虚拟方法调用
//        p2可调用的只能是子类重写父类的方法 不可调用子类特有的方法

//        如何调用子类特有方法呢？ 向下转型，使用强制类型转换符
//        但可能会出现ClassCastException异常
        Man m1 = (Man)p2;
        m1.earnMoney();


        System.out.println("[ instanceof关键字使用 ]");
/**
 * instanceof关键字使用
 *
 * a instanceof A : 判断对象a是否为类A的实例，若是返回TRUE，不是则返回FALSE
 *
 * 使用情境：
 *          为避免向下转型时出现ClassCastException异常，在转型之前
 *          进行instanceof判断，返回TRUE向下转型，反之，不转型。
 */

        if(p2 instanceof Woman){
            Woman w1 = (Woman)p2;
            w1.goShopping();
            System.out.println(">>>>>>>> Woman");
        }

        if(p3 instanceof Woman){
            Woman w1 = (Woman)p3;
            w1.goShopping();
            System.out.println(">>>>>>>> Woman");
        }

        if(p2 instanceof Man){
            Man m2 = (Man)p2;
            m2.earnMoney();
            System.out.println(">>>>>>>> Man");
        }




    }
}
