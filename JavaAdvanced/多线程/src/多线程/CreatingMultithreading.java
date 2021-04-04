package 多线程;

/**
 * 多线程创建：
 *      方式一：继承于Thread类
 *      1.创建一个继承于Thread类的子类
 *      2. 重写Thread类的run( ) ---->将此线程执行的操作声明在run()内
 *      3.创建Thread 类的子类的对象
 *      4.通过此对象调用start( )
 *
 */
public class CreatingMultithreading {
    public static void main(String[] args) {
//        3.创建Thread类的子类对象
        MyThread myThread = new MyThread();
//        4.通过此对象调用start()
        myThread.start();//一个对象只能调一个start() 否则报错:IllegalThreadStateException
//        解决方法：重新创建一个对象
       MyThread myThread1= new MyThread();
       myThread1.start();
    }
}

//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
//    2.重写Thread类的run()


    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}