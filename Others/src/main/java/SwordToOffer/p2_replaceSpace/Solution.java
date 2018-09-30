package SwordToOffer.p2;

import org.junit.Test;


public class Solution {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        while(str.indexOf(" ")!=-1){
            int index = str.indexOf(" ");
            str.replace(index,index+1,"%20");
        }
        return str.toString();
    }


    @Test
    public void test00(){
        StringBuffer str = new StringBuffer("we are the world ");
        int i = str.indexOf(" ");
        System.out.println(i);
        str.replace(2,3,"%20");  //替换规则，当前index，index+被替换字符长度
        System.out.println(str.toString());
    }

    @Test
    public void test01(){
        StringBuffer str = new StringBuffer("we are the world ");
        String s = replaceSpace(str);
        System.out.println(s);
    }
}