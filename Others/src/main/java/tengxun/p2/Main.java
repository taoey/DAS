package tengxun.p2;

import java.util.Scanner;

/**
 * Created by tao on 2018/9/16.
 */

public class Main {
    public static final int MAX =Integer.MAX_VALUE;

    public static void solve(int a,int b,int c){
        int n=1;
        for(int i = 0; n<MAX;n++){
            if(n*a/b==c){
                System.out.println("YES");
                break;
            }
        }
        if(n==MAX){
            System.out.println( "NO");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i =0;i<num;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            solve(a,b,c);
        }
    }
}
