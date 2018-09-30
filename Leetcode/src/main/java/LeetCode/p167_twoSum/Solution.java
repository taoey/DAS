package LeetCode.p167_twoSum;


import org.junit.Test;

import java.util.Arrays;

public class Solution {
    /**
     * 使用双指针思想,判断两数的和
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length-1;
        while(head<=tail){
            int tempSum = numbers[head]+numbers[tail];
            if(tempSum>target){
                tail--;
            }else if(tempSum<target){
                head++;
            }else {
                return new int[]{head+1,tail+1};
            }
        }
        return null;
    }



    @Test
    public void test00(){
        int [] arr = new int[]{2,7,11,15};
        int[] result = twoSum(arr, 9);
        System.out.println(Arrays.toString(result));
    }

}