package tujia.P2;

import java.util.Scanner;

/**
 * Created by tao on 2018/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] list = new int[sum+1];
        int [] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        //solve
        list[0]=1;
        for (int i=0;i<n;i++){
            for(int j =sum;j>=arr[i];j--){
                list[j]+=list[j-arr[i]];
            }
        }//end for

        System.out.println(list[sum]);
    }
}
