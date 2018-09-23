package string.other.getAllSubString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2018/9/22.
 */
public class Main {
    /**
     * 获取一个字符串所有的子串
     * @return
     */
    public static List getAllSubString(String string){
        List<String> stringList = new ArrayList<String>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i+1; j <= string.length(); j++) {
                stringList.add(string.substring(i,j));
            }
        }
        return stringList;
    }
    public static List getAllSubString2(String string){
        List<String> stringList = new ArrayList<String>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j <= string.length(); j++) {
                stringList.add(string.substring(i,j));
            }
        }
        return stringList;
    }

    @Test
    public void test00(){
        List r = getAllSubString2("abcdef");
        System.out.println(r);
    }
}
