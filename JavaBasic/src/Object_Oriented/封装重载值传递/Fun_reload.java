package Object_Oriented.封装重载值传递;


// 方法重载

/**
 * 1.定义：在同一个类中，允许存在一个以上的同名方法，只要他们的参数个数，或者
 *          参数类型不同即可
 */

public class Fun_reload {
    public static void main(String[] args) {
        Fun_reload fun = new Fun_reload();
        fun.getSum(1,2);
    }
    public void getSum(int i,int j){
        System.out.println("1");
    }
    public void getSum(double i,double j){
        System.out.println("2");
    }
    public void getSum(String str, int i){
        System.out.println("3");
    }

    /**
     * 以下非重载

     *  public int getSum(int i, int j){
     *
     *     }
     *     private void getSum(int i, int j){
     *
     *     }
     */
}
