package top100.p929_numUniqueEmails;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public String convertEmail(String email){
        String realLocalName = null;
        String[] split = email.split("@");
        String localName = split[0];
        String domain = split[1];

        //处理本地名
        localName = localName.replaceAll("[.]","");
        if(localName.indexOf("+")!=-1){
            realLocalName = localName.substring(0,localName.indexOf("+"));
        }
        //处理域名
        domain = domain.replaceAll("[+]","");

        return realLocalName+"@"+domain;
    }
    public int numUniqueEmails(String[] emails) {
        int sum = 0;
        Set<String> eSet = new HashSet<>();
        for(String email:emails){
            String realEmail = convertEmail(email);
            eSet.add(realEmail);
        }
        return eSet.size();
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String [] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int i = s.numUniqueEmails(emails);
        System.out.println(i);
    }

}
