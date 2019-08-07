package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    @Test
    public void test00(){
        String  patternString = "a.*b"; //匹配以a开头，以b结尾的最长字符串
        String  matcherString = "abcdefgb";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(matcherString);
        if(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
