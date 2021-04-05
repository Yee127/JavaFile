package 自定义泛型;

import org.junit.Test;

public class Tset {
    @Test
    public void test1(){
//        Order order = new Order();
//        order.setOrderT(123);
//        order.setOrderT("www");
//        指明泛型
        Order<String> order = new Order<String>("String",1001,"OrderA");
        order.setOrderT("aaaa");
    }

    @Test
    public void test2() {
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        SubOrder  subOrder = new SubOrder();
    }


}
