package package0and1;


import org.junit.Test;

public class Main {
    private class Node{
        Integer weight;
        Integer value;
        public Node(int w,int v){
            this.weight=w;
            this.value=v;
        }
    }
    public int knapscak(Node [] nodes, Integer c){
        int row;//行指针
        int col;//列指针  其含义为容量
        int count = nodes.length-1;
        int capacity = c;
        int map[][] =new int[count+1][capacity+1];   //动态规划表

        for(row=1;row<count+1;row++){
            Node cur = nodes[row]; //获取一个节点
            for(col=1;col<capacity+1;col++){
                if(cur.weight>col){  //太重，不拿
                    map[row][col] =map[row-1][col];
                }else { //此时 col>cur.weight
                    int num1 = map[row-1][col-cur.weight]+cur.value;  //拿
                    int num2 = map[row-1][col];                       //不拿
                    map[row][col] = Math.max(num1,num2);
                }
            }
        }
        return map[count][capacity];
    }
    @Test
    public void test01(){
        Integer [] weight = new Integer[]{2,3,4,5,9};
        Integer [] value = new Integer[]{3,4,5,8,10};

        int capacity=20;
        int count = 5;

        int map[][] =new int[count+1][capacity+1];   //动态规划表

        Node[] nodes = new Node[count+1];
        for(int i=0;i<nodes.length;i++){
            if(i==0){
                nodes[i]=new Node(0,0);
            }else {
                nodes[i]=new Node(weight[i-1],value[i-1]);
            }
        }

        int result = knapscak(nodes, capacity);
        System.out.println(result);
    }

    @Test
    public void test00(){
        //读入数据
        Integer [] weight = new Integer[]{2,3,4,5,9};
        Integer [] value = new Integer[]{3,4,5,8,10};

        int capacity=20;
        int count = 5;

        int map[][] =new int[count+1][capacity+1];   //动态规划表

        Node[] nodes = new Node[count+1];
        for(int i=0;i<nodes.length;i++){
            if(i==0){
                nodes[i]=new Node(0,0);
            }else {
                nodes[i]=new Node(weight[i-1],value[i-1]);
            }
        }

        //处理数据
        int row;//行指针
        int col;//列指针  其含义为容量

        for(row=1;row<count+1;row++){
            Node cur = nodes[row];  //获取一个节点
            for(col=1;col<capacity+1;col++){
                if(cur.weight>col){  //太重，不拿
                    map[row][col] =map[row-1][col];
                }else { //此时 col>cur.weight
                    int num1 = map[row-1][col-cur.weight]+cur.value;  //拿
                    int num2 = map[row-1][col];                       //不拿
                    map[row][col] = Math.max(num1,num2);
                }
            }
        }

        System.out.println(map[count][capacity]);

    }
}
