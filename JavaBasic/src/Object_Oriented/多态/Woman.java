package Object_Oriented.多态;

public class Woman extends Person{

    boolean isBeauty;

    public void goShopping(){
        System.out.println("shopping");
    }
//   重写父类方法
    public void eat()
    {
        System.out.println("吃饭 少吃");
    }
    public void walk()
    {
        System.out.println("走  慢走");
    }
}
