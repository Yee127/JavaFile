package Object_Oriented.设计模式;

public class 饿汉式设计模式 {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        Bank bank1 = Bank.getInstance();

        System.out.println(bank == bank1);

    }
}


class Bank{
    //1私有化类的构造器
    private Bank(){

    }
//    2内部创建类的对象
//    4要求类的对象也必须声明为静态的
    private static Bank instance = new Bank();


//    3提供公共的静态方法，返回类的对象
    public static Bank getInstance() {
        return instance;
    }
}