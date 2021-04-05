package 自定义泛型;

public class Order<T> {
    String orderName;
    int orderId;

    T orderT;

    public Order(){}

    public Order(String orderName,int orderId,T orderT){
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderT = orderT;
    }

    public Order(T orderT) {
        this.orderT = orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
}
