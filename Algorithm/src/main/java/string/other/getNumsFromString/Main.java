package string.other.getNumsFromString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2018/9/22.
 */
public class Main {

    /**
     * 判断一个字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNum(String str){
        try{
            Integer.parseInt(str);
        }catch (Exception e){
            return false;
        }
        return true;
    }


    /**
     *  获取一个字符串中的所有数字
     * @param str
     * @return
     */
    public static List getNumsFormStr(String str){
        List<Integer> result = new ArrayList<Integer>(50);
        for(int i=0;i<str.length();i++){
            for(int j = i+1;j<=str.length();j++){
                String temp = str.substring(i,j);
                if(isNum(temp)){
                    result.add(Integer.parseInt(temp));
                }
            }
        }
        return result;
    }

    /**
     * 获取一个字符串中最大的数字(字符串中不包含符号)
     * @param str
     * @return
     */
    public static int getMaxNumFromStr(String str){
        int max=-1;
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                String temp = str.substring(i, j);
                if(isNum(temp) && Integer.parseInt(temp)>max){
                    max = Integer.parseInt(temp);
                }
            }
        }
        return max;
    }
    @Test
    public void test00(){
        String [] strList = {"123","a2w2","a2w2e"};
        for(String str :strList){
            List nums = getNumsFormStr(str);
            System.out.println(nums.toString());
        }
    }

    @Test
    public void test01(){
        System.out.println(isNum("abc"));
        System.out.println(isNum("123"));
        System.out.println(isNum("12e"));
    }

    @Test
    public void getMaxNumFromStr(){
        int num1 = getMaxNumFromStr("223e444");
        int num2 =getMaxNumFromStr("1w2w");
        int num3 =getMaxNumFromStr("12e3");
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}
