package top100.p709_toLowerCase;


class Solution {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();

        for(int i = 0 ; i < chars.length; i++){
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                chars[i] += 32;
            }
        }
        return new String(chars);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String  str = "STudeNT";
        str = s.toLowerCase(str);

        System.out.println(str);
    }
}
