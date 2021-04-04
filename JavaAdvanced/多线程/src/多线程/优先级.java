package 多线程;

/**
 * 线程优先级：
 * 1.
 *   Max_PRIORITY: 10
 *   MIN_PRIORITY: 1
 *   NORM_PRIORITY: 5 --> 默认的优先级
 * 2.如何获取和设置当前线程的优先级？
 *   getPriority（）：获取线程的优先级
 *   setPriority（int p）：设置线程的优先级
 */

public class 优先级 {
    public static void main(String[] args) {
        myThread m = new myThread();
        m.setPriority(Thread.MAX_PRIORITY);
        m.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for(int i = 0;i<100;i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" +i);
            }
        }

    }
}

class myThread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + getPriority()+i);
            }
        }
    }
}