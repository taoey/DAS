package collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by tao on 2018/9/7.
 */
public class LinkedListStudy {

    @Test
    public void test00(){
        LinkedList<Integer> stack = new LinkedList<Integer>(Arrays.asList(1,5,6,7,2));
        stack.add(1);
        stack.peekFirst();
        stack.peekLast();
     }
}
