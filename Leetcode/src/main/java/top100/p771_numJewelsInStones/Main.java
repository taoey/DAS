package top100.p771_numJewelsInStones;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        Set<Character> jSet = new HashSet<>();
        for(int i=0;i<J.length();i++){
            jSet.add(J.charAt(i));
        }

        for(int i=0;i< S.length();i++){
            if(jSet.contains(Character.valueOf(S.charAt(i)))){
                sum++;
            }
        }
        return sum;
    }
}

/*
class Solution {
    public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : S.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int ans =0;
        for(char c : J.toCharArray()){
            ans += map.containsKey(c) ? map.get(c) : 0;
        }
        return ans;
    }
}
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.numJewelsInStones("aA", "aAAbbbb");
        System.out.println(i);
    }
}
