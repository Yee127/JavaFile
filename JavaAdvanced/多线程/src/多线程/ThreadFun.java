package 多线程;

/**
 * 测试Thread常用方法：
 *      start（）：启动当前线程；调用当前线程的run（）
 *      run（）：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 *      currentThread（）：静态方法，返回当前代码执行的线程
 *      getName（）：获取当前线程的名字
 *      setName（）：设置当前线程的名字
 *      yield():释放当前cpu执行权
 *      join():在线程A中调用线程B的Join（），此时线程A就会进入阻塞状态，直到线程B完全执行完以后
 *              线程A才结束阻塞状态
 *      stop():已过时（执行此方法时，强制结束当前线程）
 *      sleep(long millis):
 *      isAlive()：判断当前线程是否存活
 */
public class ThreadFun {
    public static void main(String[] args) {
        helloThread h = new helloThread("hello");
//        h.setName("helloThread");
        h.start();

//        给主线程命名
        Thread.currentThread().setName("主线程");
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"："+i);

            }
            System.out.println(h.isAlive());;

//            if(i == 20){
//                try {
//                    h.join();
//                }catch (Exception e){
//                    System.out.println("????");
//                }
//            }
        }
    }
}
class helloThread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(helloThread.currentThread().getName()+"："+i);
                try {
                    sleep(1000);
                }catch (Exception e)
                {
                    System.out.println("!!!!");
                }

            }
//            if(i % 20 == 0)
//            {
//                this.yield();
//            }
        }
    }
    public helloThread(String name){
        super(name);
    }
}