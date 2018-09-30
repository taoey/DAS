package leetcode99;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Entry{
    private Integer count;  //次数
    private Integer place;  //最小位置
    public Entry(){};

    public Entry(Integer count, Integer place) {
        this.count = count;
        this.place = place;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }
}

public class FreqStack {
    List<Integer> stack;
    Map<Integer,Entry> numMap;
    public FreqStack() {
        stack = new ArrayList<Integer>();
        numMap = new HashMap<Integer,Entry>();  //数据索引
    }

    public void push(int x) {
        stack.add(x);
        if (!numMap.containsKey(x)){
            numMap.put(x,new Entry(1,stack.size()));
        }else {
            Entry temp = numMap.get(x);
            temp.setCount(temp.getCount()+1);
            temp.setPlace(stack.size());
        }
    }

    public int pop() {
        int max;
        //获取最大
        for (int i = 1; i < stack.size(); i++) {
            int num = stack.get(i);
            int num2 = stack.get(i-1);
            if(numMap.get(num).getCount()>numMap.get(num2).getCount()){
                max = num;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(3);
    }
}
