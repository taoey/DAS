package LeetCode.p150_evalRPN;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 逆波兰表达式求值问题，该题实际上是LeetCode_150题
 */
public class Solution {
    public boolean isNum(String str){
        boolean result = false;
        char[] chars = str.toCharArray();
        for (int i = 0; i <chars.length; i++) {
            if(i==0 && chars[i]==45){
                continue;
            }
            if(chars[i]>=48 && chars[i]<=57){
                result = true;
            }
        }
        return  result;
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<tokens.length;i++){
            if(isNum(tokens[i])){
                stack.offer(Integer.parseInt(tokens[i]));
            }else {
                int second = stack.pollLast();
                int first = stack.pollLast();
                String tempStr = tokens[i];
                int tempResult=0;
                //判断该符号
                if("+".equals(tempStr)){
                    tempResult=first+second;
                }else if("-".equals(tempStr)){
                    tempResult= first-second;
                }else if("*".equals(tempStr)){
                    tempResult= first*second;
                }else if("/".equals(tempStr)){
                    tempResult= first/second;
                }
                stack.offer(tempResult);
            }
        }
        return stack.pollLast();
    }




    @Test
    public void test00(){
        String [] strs = new String[]{"2","1","+","3","*"};
        String [] strs1 = new String[]{"0","3","/"};
        String [] strs2 = new String[]{"4","3","-"};
        String [] strs3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int resullt = evalRPN(strs1);
        System.out.println(resullt);
    }

    @Test
    public void test01(){
        String[] strs  =new String[]{"-11","-"};
        for(String s :strs){
            System.out.println(isNum(s));
        }
    }

}
