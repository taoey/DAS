package p10_Fibonacci;

/**
 * 计算斐波那契数列的几种方式
 */
public class Solution {
    /**
     * 最常见的递归方式
     * @param n
     * @return
     */
    public int Fibonacci_1(int n) {
        if(n<=1){
            return n;
        }else{
            return Fibonacci_1(n-1)+Fibonacci_1(n-2);
        }
    }

    public int Fibonacci_2(){
        
        return 0;
    }



}
