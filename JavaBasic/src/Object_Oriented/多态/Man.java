package Object_Oriented.多态;

public class Man extends Person {
    boolean isSmoking;

    public void earnMoney(){
        System.out.println("man 特有  赚钱");
    }

//    重写父类方法
public void eat()
{
    System.out.println("吃饭 赚钱");
}
    public void walk()
    {
        System.out.println("走路霸气");
    }
}
