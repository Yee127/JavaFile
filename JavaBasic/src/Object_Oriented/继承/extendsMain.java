package Object_Oriented.继承;

/**
 * 继承性优点：
 *      减少了代码冗余，提高代码复用性
 *      便于功能扩展
 *      为多态提供了前提
 *
 *
 * 特别：子类继承父类仍认为继承了父类的私有的结构，但由于封装性
 *      影响，子类不能直接调用父类的私有结构
 * Java对于继承的规定：
 *      一个类可以被多个子类继承
 *      Java中类的单继承性，一个类仅有一个父类
 *
 *
 */
public class extendsMain {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setEat("chifan");
        System.out.println(stu.getEat());
        stu.M(); 


    }
}
