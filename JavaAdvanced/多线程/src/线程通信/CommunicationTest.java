package 线程通信;

import java.io.ObjectOutput;

/**
 * eg：
 *      使用俩线程打印1-100  线程1，2交替打印
 *
 *
 *涉及到的三个方法：
 * wait():一旦孜行此方法，当前我程就迸入阻塞状杰，并释放同歩監視器。
 * notify(): -旦丸行此方法，就会喚醒被wait的一个銭程。如果有多个线程被wait,就喚醒代先級高的
 * notifyAll():一旦丸行此方法，就会喚醒所有被wait的銭程。
 * 説明:
 * 1.wait(), notify(), notifyAll()三个方法必須使用在同歩代码抉或同歩方法中。
 * 2. wait(), notify(), notifyAll()三方法的凋用者必須是同歩代码抉或同歩方法中的同歩監視器
 * 否則，会出現ILlegalMonitorstateException昇常
 * 3.三个方法定义在java.lang.Object类中
 */


class Number implements Runnable{
    private int num = 1;
    private Object object = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (object){
                object.notify();
                if(num <= 100){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num++;
                    try {
//                        使得调用wait()方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else break;
            }

        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);

        thread1.setName("T1");
        thread2.setName("T2");

        thread1.start();
        thread2.start();


    }
}