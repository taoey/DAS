package NetEase.P2;

import java.util.Scanner;

/**
 * Created by tao on 2018/9/8.
 * 牌面向下的个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        for(int i = 0; i<sum;i++){
            int n = in.nextInt();
            int k = in.nextInt();

            //solve
            int min =0;
            int max =0;
            if(n<3){
                max = 0;
            }else{
                if((n-1)/2>k+1){
                    max = k/2;
                }else{
                    int mid =(n-1)/2;
                }
            }

            System.out.print(0+" "+max);
            System.out.println();




        }
    }
}
