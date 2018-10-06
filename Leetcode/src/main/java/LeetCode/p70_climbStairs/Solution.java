package LeetCode.p70_climbStairs;

import org.junit.Test;

/*
爬楼梯问题
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
 */

/**
 * 实际上就是求斐波那契数列
 */
public class Solution {

    public int climbStairs(int n) {
        int result ;
        result=dfs(n);

        return result;
    }

    /**
     * 使用递归算法，比较暴力，LeetCode测试结果：时间超限
     * @param n
     * @return
     */
    public int dfs(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return dfs(n-1)+dfs(n-2);
    }

    /**
     * 使用递推方式求算斐波那契数列
     * @param n
     * @return
     */
    public int recursion(int n){
        if(n<3){
            return n;
        }else {
            int a =1,b=2,temp;
            for(int i=2;i<n;i++) {
                temp = b;
                b += a;
                a = temp;
            }
            return b;
        }
    }

    @Test
    public void test00(){
        int dfs = climbStairs(10);
        System.out.println(dfs);
    }
}
