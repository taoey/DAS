package dynamic_programming.p53_maximum_subarray;

import org.junit.Test;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            //不拿：nums[i] 拿：dp[i-1]+nums[i]
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            //如果拿了nums[i],更新sum
            if(sum<dp[i]){
                sum=dp[i];
            }
        }
        return sum;
    }
}
public class Main {
    Solution solution = new Solution();

    @Test
    public void test(){
        int [] nums =  {-2,1,-3,4,-1,2,1,-5,4};
        int result = solution.maxSubArray(nums);
        System.out.println(result); //6
    }

}
