package string.leetcode_131;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2018/9/13.
 * 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 */
public class Solution {
    /**
     * 判断一个字符串是否是回文
     * @param string
     * @return
     */
    public  boolean isPalindrome(String string){
        boolean result = true;
        int low = 0;
        int high =string.length()-1;
        while (low<high){
            if(string.charAt(low)==string.charAt(high)){
                low++;
                high--;
            }else{
                return false;

            }
        }//如果成功执行了while，此字符串必定为回文
        return result;
    }

    public List<List<String>> result;


    public  List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        return null;
    }

    public void findPalindrome(String s ,int left){

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s ={"aa","abc","aba"};
        for (int i = 0; i < s.length; i++) {
            System.out.println(solution.isPalindrome(s[i]));
        }
    }

}
