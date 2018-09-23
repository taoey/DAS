package string.me.findAllSubstrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2018/9/13.
 *  获取一个字符串的所有子串
 */
public class Solution {

    public static List firdAllSubString(String string){
        List<String> stringList = new ArrayList<String>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i+1; j <= string.length(); j++) {
                stringList.add(string.substring(i,j));
            }
        }
        return stringList;
    }


    public static void main(String[] args) {
        String s = "abcd";
        List list = firdAllSubString(s);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
