package LeetCode.p347_topKFrequent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        List<Integer> [] buckets = new ArrayList[nums.length+1];
        int pre = nums[0];
        int count=1;

        for(int i=1;i<nums.length;i++){
            int cur = nums[i];
            if(cur==pre){
                count++;
            }else {
                //注意需要对bucket进行初始化，不然会因为null而插不进去
                if(buckets[count]==null){
                    buckets[count] = new ArrayList<>();
                }
                buckets[count].add(pre);
                pre=cur;
                count=1;
            }
        }

        //插入最后一个元素
        if(buckets[count]==null){
            buckets[count] = new ArrayList<>();
        }
        buckets[count].add(pre);


        //倒叙读取桶中元素
        for(int i=buckets.length-1;i>0 && k>0;i--){
            if(buckets[i]!=null && !buckets[i].isEmpty()){
                for(Integer m: buckets[i]){
                    result.add(m);
                    k--;
                }
            }
        }
        return result;
    }


    @Test
    public void test00(){
        int [] arr = new int[]{1};
        List<Integer> integers = topKFrequent(arr, 1);
        System.out.println(integers);
    }
}
