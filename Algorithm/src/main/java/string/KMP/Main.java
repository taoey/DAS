package string.KMP;

/**
 * Created by tao on 2018/9/4.
 *  字符串匹配算法合集
 *      暴力匹配算法
 *      KMP算法
 *      Java String的Indexof 算法实现探究
 */

public class Main {
    /**
     *暴力匹配 算法
     * @param str 要进行匹配的字符串
     * @param partten 匹配模式
     * @return  首个匹配到的字母的位置
     */
    public static int violentMatch(String str,String  partten){
        int i = 0;
        int j = 0;
        while (i<str.length() && j<partten.length()){
            if(str.charAt(i)==partten.charAt(j)){
                i++;
                j++;
            }else {
                i = i-j+1;
                j = 0;
            }
        } //end while 两种情况：i>=str.length()，没有匹配到；j>=partten.length() 匹配到了

        if(j==partten.length()){
            return i-j;
        }else {
            return -1;
        }

    }
    /**
     * KMP 算法
     * @param str 要进行匹配的字符串
     * @param partten 匹配模式
     * @return  首个匹配到的字母的位置
     */
    public static int KMP (String str ,String partten){

        return 0;
    }


    public static void main(String[] args) {
        String  str = "BBC ABCDAB ABCDABCDABDE";
        String patten = "ABCDABD";
        int result1 = violentMatch(str, patten); //暴力破解
        int result2 = str.indexOf(patten);       // 未知
        System.out.println(result1);
        System.out.println(result2);
    }
}
