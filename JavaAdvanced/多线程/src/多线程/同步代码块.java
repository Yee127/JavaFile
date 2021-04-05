package 多线程;

/**
 * 方式一:同步代码块
 *      synchronized(同步监视器){
 *          //需要被同步的代码
 *      }
 * 说明: 1. 操作共享数据的代码，即为需要被同步的代码
 *      2.共享数据:多个线程共同操作的变量。比如: ticket就是共享数据。
 *      3.同步监视器，俗称:锁。任何一个类的对象，都可以充当锁。
 *      要求:多个线程必须要共用同一把锁。
 *      补充： 在实现Runnable接口创建多线程的方式中，我们可以使用this充当锁
 * 方式二:同步方法.
 *      5.同步的方式，解决了线程的安全问题。--- 好处
 *      操作同步代码时，，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。
 */
public class 同步代码块 {
    public static void main(String[] args) {
        /**
         * 继承Thread类方式
         */
        Windows windows1 = new Windows();
        Windows windows2 = new Windows();
        Windows windows3 = new Windows();

        windows1.setName("Window 1");
        windows2.setName("Window 2");
        windows3.setName("Window 3");

        windows1.start();
        windows2.start();
        windows3.start();

        /**
         * 接口Runnable方式
         */
        Win win = new Win();

        Thread thread1 = new Thread(win);
        Thread thread2 = new Thread(win);
        Thread thread3 = new Thread(win);

        thread1.setName("Win1");
        thread2.setName("Win2");
        thread3.setName("Win3");

//        thread1.start();
//        thread2.start();
//        thread3.start();



    }
}


class Windows extends Thread {
    private static int ticket = 100;
    private static Object object = new Object();//设置为静态的  共用同一把锁

//    @Override
//    public void run() {
//        while (true){
//            synchronized (object){
//                if(ticket >0)
//                {
//                    try {
//                        Thread.sleep(150);
//                    }catch (Exception e){
//                        System.out.println("error......");
//                    }
//                    System.out.println(getName()+": 卖票，票号："+ticket);
//                    ticket--;
//                }else break;
//            }
//
//        }
//    }

    /**
     * 同步方法  继承Thread的
     */
    @Override
    public void run() {
        while (true){
            show();
        }
    }

    public static synchronized void show(){
        if(ticket >0)
        {
            try {
                Thread.sleep(150);
            }catch (Exception e){
                System.out.println("error......");
            }
            System.out.println(Thread.currentThread().getName()+": 卖票，票号："+ticket);
            ticket--;
        }
    }
}

class Win implements Runnable{
    private int ticket = 100;
    Object object = new Object();

//    @Override
//    public void run() {
//        while (true){
//            synchronized (object){
//                if(ticket >0)
//                {
//                    try {
//                        Thread.sleep(150);
//                    }catch (Exception e){
//                        System.out.println("error......");
//                    }
//                    System.out.println(Thread.currentThread().getName()+": 卖票，票号："+ticket);
//                    ticket--;
//                }else break;
//            }
//
//        }
//    }

    /**
     * 同步方法  runnable
     */
    @Override
    public void run() {
        while (true){
            show();
        }
    }

    public synchronized void show(){
        if(ticket >0)
                {
                    try {
                        Thread.sleep(150);
                    }catch (Exception e){
                        System.out.println("error......");
                    }
                    System.out.println(Thread.currentThread().getName()+": 卖票，票号："+ticket);
                    ticket--;
                }
    }
}