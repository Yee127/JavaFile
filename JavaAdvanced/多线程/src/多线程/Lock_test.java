package 多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方式三：  Lock锁  ----JDK5.0 新增
 *
 */
class Window implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                //调用锁定方法 lock（）
                lock.lock();

                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"售票，票号："+ ticket);
                    ticket--;
                }else break;

            }finally {
                lock.unlock();
            }
        }
    }
}
public class Lock_test {
    public static void main(String[] args) {
        Window window = new Window();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
