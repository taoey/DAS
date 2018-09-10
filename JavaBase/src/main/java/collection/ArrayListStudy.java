package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2018/9/10.
 */
public class ArrayListStudy {


    @Test
    public void sizeStudy(){
        List<Integer> testList = new ArrayList<Integer>();
        for(int i =0;i<10;i++){
            testList.add(1);
        }
        for(int i =0;i<100;i++){
            System.out.println(i);
            testList.add(1);
        }
    }
}
