package Thread;

import org.junit.Test;

/**
 * Created by tao on 2018/9/9.
 * 理解线程的7种状态
 *
 */
public class ThreadStatus {

    /**
     * 通过实现Runnable接口实现多线程
     */
    class MyThread implements Runnable{

        public void run() {
            while(true) System.out.println("我是自定义线程。。。");
        }
    }
    /**
     *  init ready-to-run run dead
     */
    @Test
    public void test00(){
        Thread mainThread = new Thread(new MyThread());  //主线程启动另一个线程
        mainThread.start();
        while(true) System.out.println("我是主线程。。。。");
    }
}
