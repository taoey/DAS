package NetEase.P1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tao on 2018/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<3;i++){
            int temp = in.nextInt();
            list.add(temp);
        }
        Collections.sort(list);
        System.out.println(Math.abs(list.get(1)-list.get(0))+Math.abs(list.get(2)-list.get(1)));
    }
}
