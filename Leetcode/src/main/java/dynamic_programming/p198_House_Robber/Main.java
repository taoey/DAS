package dynamic_programming.p198_House_Robber;

import org.junit.Test;

class Solution {
    public int rob(int[] nums) {
        //子问题
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if (nums.length==2) return  Math.max(nums[0],nums[1]);

        //数据容器
        int[] dp = new int[nums.length];

        //递推
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

}

public class Main{

    Solution solution = new Solution();
    @Test
    public void test(){
        int [] nums ={1,2,3,1};
        System.out.println(solution.rob(nums));
    }
}