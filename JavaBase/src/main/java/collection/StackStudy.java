package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2018/9/7.
 */
public class StackStudy {

    @Test
    public void  test00(){
        List<Integer> stack  = new ArrayList<Integer>();
        stack.add(1);
        stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
    }
}
