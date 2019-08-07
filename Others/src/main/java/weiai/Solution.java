package weiai;

import java.util.ArrayList;
import java.util.List;

public class Solution {

   public static List<Vo> solve(List<Vo> list){
       List<Vo> result = new ArrayList<>(list.size());

       if(list.size()==1){
            return list;
       }

       Vo pre = list.get(0);

       int count=pre.num;
       for(int i=1;i<list.size();i++){
           Vo cur = list.get(i);
           if(pre.date==cur.date){
               count += cur.num;
           }else {
               Vo temp = new Vo(count,null,cur.date);
               pre = cur;
               result.add(temp);
               count=cur.num;
           }
       }
       result.add(new Vo(count,null,pre.date));
       return result;
   }

    public static void main(String[] args) {
        List<Vo> list = new ArrayList<>();
        Vo vo1 = new Vo(1,"ios",25);
        Vo vo2 = new Vo(2,"android",26);
        Vo vo3 = new Vo(3,"win",26);
        Vo vo4 = new Vo(4,"aa",26);
        Vo vo5 = new Vo(5,"aa",27);

        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        list.add(vo4);
        list.add(vo5);




        List<Vo> solve = solve(list);
        for(Vo vo:solve){
            System.out.println(vo.num);
        }


    }
}
