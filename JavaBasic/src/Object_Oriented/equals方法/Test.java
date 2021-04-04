package Object_Oriented.equals方法;

public class Test {
    public static void main(String[] args) {
        Order order = new Order(111,"SB");
        Order order1 = new Order(112,"SD");

        boolean A = order.equals(order1);
        System.out.println(A);
    }
}
