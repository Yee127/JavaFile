package Object_Oriented.封装重载值传递;
//封装与隐藏

/**
 * 封装性的体现：
 *      将类的属性私有化（private），同时，提供公有方法（public）来获取（getXxx）
 *      和设置（setXxx）
 */

/**
 * 封装性的体现需配合权限修饰符来配合：
 *      Java规定的4种权限：private < 缺省 < protected < public
 *      4种权限可以用来修饰类以及累的内部结构：属性，方法，构造器，内部类
 *          修饰类：只能缺省，public
 *
 */
public class FengZhuang {
    public static void main(String[] args) {
        Animal a = new Animal();
//        a.name = "huahua";
//        a.legs = 4;
//        a.age = 3;
        a.setAge(11);
        a.setLegs(4);
        a.setName("hahahah");
        a.show();
    }
}


class Animal{
    private String name;
    private int age,legs;

    public void eat(){
        System.out.println("Eatting......");
    }
    public void setName(String Name){
        name = Name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int Age){
        age = Age;
    }
    public int getAge(){
        return age;
    }

    public void setLegs(int l)
    {
        legs = l;
    }
    public void show(){

        System.out.println("name: "+name+"\tage: "+age+"\tlegs: "+legs);
    }
}