package collection;


import java.util.*;

public class MapStudy {
    public static void main(String[] args) {
        Map hashMap = new HashMap<Integer,String>();
        Map treeMap = new TreeMap<Integer,String>();
        Map hashTable  = new Hashtable<Integer,String>();
        Map linkedHashMap = new LinkedHashMap<Integer,String>();

        treeMap.put(1,"a");
        treeMap.put(2,"b");
        treeMap.put(3,"c");

        hashMap.put(1,"a");
        hashMap.put(2,"b");
        hashMap.put(3,"c");


        System.out.println(treeMap);



    }
}
