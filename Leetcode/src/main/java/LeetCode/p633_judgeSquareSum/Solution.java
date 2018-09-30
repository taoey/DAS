package LeetCode.p633_judgeSquareSum;


import org.junit.Test;

public class Solution {

    /**
     * 双指针法，一个头一个尾
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int head = 0; //注意题目给的是两个整数，而不是两个正整数，所以head=0，而不是head=1
        int tail = (int)Math.sqrt(c);
        while(head<=tail){
            int temp = head*head+tail*tail;
            if(temp>c){
                tail--;
            }else if(temp<c){
                head++;
            }else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test00(){
        boolean b = judgeSquareSum(8);
        System.out.println(b);
    }

}