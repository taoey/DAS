package tengxun.p1;

import java.util.Scanner;

/**
 * Created by tao on 2018/9/16.
 */
public class Main {

    //最小公倍数
    public static int minNum(int m,int n){
        //最大公约数
        int maxNum=-1;
        int max = Math.max(m,n);
        int min = Math.min(m,n);

        while (min!=0){
            int r = max %min;
            max = min;
            min = r;
        }
        maxNum=max;
        return  m*n/maxNum;

    }

    public static int solve(int num){
        boolean flag = true;
        int temp = num+1;
        int temp2=1;
        temp = minNum(temp,temp);
        for(int i = 1;i<=num+1;i++){
            temp2 = minNum(temp2, i);
        }
        if(temp ==temp2){
            return num+1;
        }
        int count = 2;
        while (flag){
            temp=minNum(temp,count+num);
            temp2=minNum(temp2,count+num);
            if(temp==temp2){
                return count+num;
            }else{
                count++;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solve(n));
    }
}
