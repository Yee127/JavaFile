package 多线程Practice;

public class ThreadDemo {
    public static void main(String[] args) {
        /**
         * 常规方式
         */
//        MyThread1 myThread1 = new MyThread1();
//        MyThread2 myThread2 = new MyThread2();
//
//        myThread1.start();
//        myThread2.start();

        /**
         * Thread类的匿名子类方式
         */

        new Thread(){
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println("偶数：" + i);
                    }
                }
            }
        }.start();

        new Thread(){
            public void run() {
                for(int i = 0;i<100;i++){
                    if(i%2!=0){
                        System.out.println("奇数："+i);
                    }
                }
            }
        }.start();
    }

}


class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println("偶数："+i);
            }
        }
    }
}


class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if(i%2!=0){
                System.out.println("奇数："+i);
            }
        }
    }
}