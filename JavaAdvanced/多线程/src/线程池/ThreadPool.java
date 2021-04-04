package 线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
//        1、提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
//       2、执行指定线程的操作，需要提供实现Runnable的接口或Callable的接口实现类的对象
        NumThread num1 = new NumThread();
        service.execute(num1);//适用于 Runnable
//        service.submit();//适用于Callable
//        3、关闭线程池
        service.shutdown();
    }
}

class NumThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i<100 ;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}