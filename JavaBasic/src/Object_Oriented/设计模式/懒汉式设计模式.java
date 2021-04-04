package Object_Oriented.设计模式;

public class 懒汉式设计模式 {
    public static void main(String[] args) {
        Order order = Order.getInstance();
        Order order1 = Order.getInstance();

        System.out.println(order == order1);
    }
}

class Order{
//    1、私有化类的构造器
    private Order(){

    }

//    2、声明当前类的变量
    private static Order instance = null;
//    3、声明公共静态的 返回当前类的方法
    public static Order getInstance() {
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }
}