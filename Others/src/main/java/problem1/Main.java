package problem1;

import java.util.*;


class Node{
	public int left;
	public int right;
	public Node(int left,int right) {
		this.left=left;
		this.right=right;
	}
}
public class Main {
	public static int n,m;
	public static Map<Integer,Node> map ;
	public static List b ;
	public static int query(int num) {
		System.out.println(m);
		
		return  0;
	}
    public static void main(String[] args) {
    	b = new ArrayList<Integer>();
    	Scanner in = new Scanner(System.in);
    	map=new HashMap<Integer, Node>();
    	//input
    	
    	n=in.nextInt();
    	int sum=0;
    	//得到查询表
    	for(int i=0;i<n;i++) {
    		int temp = in.nextInt();
    		map.put(i, new Node(sum,sum+temp));
    		sum=temp+sum;
    	}
    	//进行查询
    	m=in.nextInt();
    	for(int i =0;i<m;i++) {
    		int num = in.nextInt();
    		for(int j=0;j<n;j++) {
    			Node t = map.get(i);
    			if(num>t.left && num<=t.right) {
    				b.add(i+1);
    				break;
    			}    		
    		}
    	}
    	for(int i=0;i<b.size();i++) {
    		System.out.println(b.get(i));
    	}
    }
}