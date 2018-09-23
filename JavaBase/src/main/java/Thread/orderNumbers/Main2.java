package Thread.orderNumbers;


class MyTask2 implements Runnable{
    volatile int count =0;
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName()+":"+count);
        }
    }


}
public class Main2 {
    public static void main(String[] args) {
        MyTask2 task2 = new MyTask2();
        Thread t1 =new Thread(task2);
        Thread t2 =new Thread(task2);
        t1.start();
        t2.start();
    }


}
