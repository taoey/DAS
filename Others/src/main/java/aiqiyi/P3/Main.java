package aiqiyi.P3;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count=1;
        List<Integer> arr = new ArrayList<>(1000);
        int sum= in.nextInt();
        for(int i =0;i<sum;i++){
           arr.add(in.nextInt());
        }

        Collections.sort(arr);
        int pre = arr.get(0);
        int tempCount =1;
        for(int i=1;i<arr.size();i++){
            int cur = arr.get(i);
            if(cur==pre){
                tempCount++;
            }else if(tempCount>count){
                count=tempCount;
                tempCount=1;
            }else {
                tempCount=1;
            }
            pre = cur;
        }
        if(tempCount>count){
            count=tempCount;
        }
        System.out.println(count);


    }
}
