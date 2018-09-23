package zjtd.P2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tao on 2018/9/20.
 */
public class Main {

    /**
     * 获取最大相同坐标
     * @param a
     * @param b
     * @return
     */
    public static int getIndex(String a,String b){
        int min = Math.min(a.length(),b.length());
        int i;
        for(i=1;i<=min;i++){
            String x = a.substring(0,i);
            String y = b.substring(0,i);
            if(!x.equals(y)){
                return i-1;
            }
        }

        return i-1;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String countStr = in.nextLine();
        int count = Integer.parseInt(countStr);
        List<String> strs = new ArrayList<String>(count);
        String [] result = new String [count];
        for(int i=0;i<count;i++){
            strs.add(in.nextLine());
        }
        for(int i=1;i<count;i++){
            String a  = strs.get(i);
            for(int j = 0;j<i;j++){
                String b = strs.get(j);
                int index = getIndex(a, b);
                if((index==0 && result[j]==null)||(index==0 && result[j].length()< index)){
                    result[j] = b.substring(0,1);
                    result[j+1] = a.substring(0,1);
                }else if((index!=0 && result[j]==null)||(index!=0 && result[j].length()< index)){
                    result[j] = b.substring(0,index+1);
                    result[j+1] = a.substring(0,index+1);
                }
            }
        }

        for(String s:result){
            System.out.println(s);
        }
    }

//
//    @Test
//    public void test(){
//        int index = getIndex("dd", "abc");
//        System.out.println(index);
//    }
}
