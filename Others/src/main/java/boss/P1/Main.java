package boss.P1;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static  boolean isNum(char mychar){
        return (mychar>=48 && mychar<=57);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(100,cmp);
        int i;
        int index=0;
        boolean flag = true;
        while(index!=str.length()+1){
            flag = true;
            for ( i=index;i<str.length();i++){
                if(!isNum(str.charAt(i)) || i==str.length()-1){
                    flag = false;
                    index=i+1;
                    break;
                }
            }// i处不是数字
            if(!flag){
                String substring;
                if(i==str.length()+1 && isNum(str.charAt(index))){
                    substring = str.substring(index,str.length());
                }else{
                    substring = str.substring(index, i);
                }
                //判断子串
                if(!substring.equals("")){
                    queue.offer(Integer.parseInt(substring));
                }else{
                    break;
                }
            }


        }
        System.out.println(queue.poll());

    }


    @Test
    public void test00(){
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10,cmp);
        queue.offer(22);
        queue.offer(9);
        queue.offer(3);

        Integer poll = queue.poll();
        System.out.println(poll);
    }

    @Test
    public void test01(){
        boolean num = isNum('e');
        System.out.println(num);
    }
}
