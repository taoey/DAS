package tujia.P1;

import java.util.Scanner;

/**
 * Created by tao on 2018/9/10.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m,n;
        m=in.nextInt();
        n=in.nextInt();

        //最大公约数
        int maxNum=-1;
        int max = Math.max(m,n);
        int min = Math.min(m,n);
        //
//        if (max%min==0){
//            maxNum = Math.min(m,n);
//        }else {
//            for (int i =1;i<min;i++){
//                if(min%i==0 && max%1==0){
//                    maxNum = i;
//                }
//            }
//        } //end maxNum
        while (min!=0){
            int r = max %min;
            max = min;
            min = r;
        }
        maxNum=max;


        //最小公倍数
        int minNum = m*n/maxNum;
        System.out.println(maxNum);
        System.out.println(minNum);



    }
}
