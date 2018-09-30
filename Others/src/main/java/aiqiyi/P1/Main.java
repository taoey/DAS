package aiqiyi.P1;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count=0;
        Queue<Integer>  d = new PriorityQueue<>(1000);
        int sum= in.nextInt();
        for(int i =0;i<sum;i++){
            d.offer(in.nextInt());
        }

        int pre = d.poll();

        while(!d.isEmpty()){
            Queue<Integer> td = new PriorityQueue<>(1000);
            while(!d.isEmpty()){
                Integer cur = d.poll();
                if(cur==pre){
                    td.offer(cur);
                }
            }//此时d为空，td可能不为空
            count++;
            d =td;
        }
        System.out.println(count);

    }
}
