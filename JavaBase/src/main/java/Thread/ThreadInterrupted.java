package Thread;

/**
 * Created by tao on 2018/9/9.
 *  如何中断一个线程并恢复
 */
/**
 * 自定义线程
 */
class MyThread extends Thread{

    @Override
    public void run(){
        int count =0;
        while(!interrupted()){
            count++;
            if(count % 101 ==1)
                System.out.println(getName()+"线程正在运行......");
        }

    }
} //end MyThread

public class ThreadInterrupted {

    public static void main(String[] args)  {
        MyThread t1 = new MyThread();

        t1.start();

        t1.interrupt();





    }



}
