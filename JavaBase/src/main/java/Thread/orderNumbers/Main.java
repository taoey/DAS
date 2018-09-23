package Thread.orderNumbers;

/**
 * 多个线程打印1-n
 */

class MyTask implements Runnable{
    int count =0;
    public void run() {
        while (true) {
            synchronized (this) {
                // 先唤醒另外一个线程
                notify();
                try {
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":"+ count);
                    count++;
                    try {
                        // 打印完之后，释放资源，等待下次被唤醒
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
public class Main {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t1 =new Thread(task);
        Thread t2 =new Thread(task);
        t1.start();
        t2.start();
    }


}
