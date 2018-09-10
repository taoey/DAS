package JD.P1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tao on 2018/9/9.
 */

class Node{
    private int a;
    private int b;
    private int c;

    public Node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Node> passList = new LinkedList<Node>();
        int result = 0;

        int count = in.nextInt();
        for(int i = 0;i<count;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            if(passList==null || passList.size()==0){  //添加第一个元素作为标准
                passList.add(new Node(a,b,c));
            }else{
                int listSize = passList.size();
                for(int j=0;j<listSize;j++){
                   // boolean compare = a>passList.get(j).getA() && b>passList.get(j).getB() && c>passList.get(j).getC();
                    if(a>=passList.get(j).getA() || b>=passList.get(j).getB() || c>=passList.get(j).getC()){  //new 合格
                        if(a>passList.get(j).getA() && b>passList.get(j).getB() && c>passList.get(j).getC()){  //old 不合格
                            passList.remove(j);
                            passList.add(new Node(a,b,c));
                            result++;
                        }else {    //old也合格
                            passList.add(new Node(a,b,c));
                        }
                    }else{  //new 不合格
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
