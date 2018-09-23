package xunlei_1.P1;

import java.util.*;

/**
 * Created by tao on 2018/9/12.
 * 合并区间
 * https://www.nowcoder.com/question/next?pid=12398771&qid=247583&tid=18519371
 */
public class Main {
    private static class Node implements Comparable<Node>{
        public Integer x;
        public  Integer y;

        public Node(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Node o) {
            return this.x-o.x;
        }
    }
    public static Node getNum(String str){
        String[] strList = str.split(",");
        Integer x = Integer.parseInt(strList[0]);
        Integer y = Integer.parseInt(strList[1]);
        return new Node(x,y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] a = s.split(" "); //区间合集
        List<Node> nodes = new ArrayList<Node>();
        //添加第一元素

        //遍历
        for (int i = 0; i < a.length; i++) {
            Node tempNode = getNum(a[i]);
            nodes.add(tempNode);
        }
        Collections.sort(nodes);
        List<Node> results = new LinkedList<Node>();
        for (int i = 0; i < nodes.size(); i++) {
            if(results.size()==0){   //初始化进入
                results.add(nodes.get(i));
            }else{   //只需要和前一个区间对比即可（最小区间已经排好序了）
                Node current = nodes.get(i);
                int len = results.size()-1;
                Node pre = results.get(len);

                //TODO
                if((current.x<=pre.y && current.y>pre.y) || current.x-1==pre.y ||(current.x==pre.x && current.x<=pre.y )){ //可以合并
                    if(current.x!=current.y){  //x=y时不添加
                        Node newNode = new Node(pre.x,current.y);
                        results.set(len,newNode); //更新
                    }
                }else{    //不可合并
                    results.add(current);
                }
            }
        }

        //输出
        for (int i = 0; i < results.size(); i++) {
            Node cur = results.get(i);
            System.out.print(cur.x+","+cur.y);
            System.out.print(" ");
        }

    }
}
