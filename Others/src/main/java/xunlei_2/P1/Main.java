package xunlei_2.P1;

import java.util.Scanner;

/**
 * 计算勾股数 - 后台开发工程师
 */
public class Main {

    public static int getMaxGong(int a,int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        while (min!=0){
            int r = max %min;
            max = min;
            min = r;
        }
        return max;
    }
    public static boolean isSu(int a,int b,int c){
        int maxGong = getMaxGong(a, b);
        int maxGong1 = getMaxGong(maxGong, c);
        if(maxGong1==1){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 0;
        for(int i = 1; i < num; i++) {

            for (int j = i; j < num; j++) {

                for (int n = j + 1; n < num; n++) {

                    if ((i * i + j * j) == n * n && isSu(i,j,n)) {
                        count++;
                    }

                }

            }
        }
        System.out.println(count);

    }

}
