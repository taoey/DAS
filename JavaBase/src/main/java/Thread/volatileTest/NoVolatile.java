package Thread.volatileTest;

import org.junit.Test;


class MyTask implements Runnable{
    private int count;
    MyTask(int count){
        this.count=count;
    }
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName()+":"+count);
        }
    }
}

public class NoVolatile {
    private int count = 0;
    @Test
    public void noVolatile() throws InterruptedException {
        MyTask myTask = new MyTask(count);
        Thread t1 = new Thread(myTask);
        Thread t2 = new Thread(myTask);
        Thread t3 = new Thread(myTask);
        t1.start();
        t2.start();
        t3.start();
        while (true){}

    }
}
