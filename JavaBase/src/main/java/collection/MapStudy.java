package collection;


import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
        System.out.println(hashMap);

    }

    /**
     * key.hashCode >>>16 含义为：取key.hashCode 的高16位（原来的高16位变成了0）
     *
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);  //高16位和低16位进行异或操作
    }
    @Test
    public void HashMapStudy(){
        //定义了一个容量为10，负载因子为0.5的HashMap
        Map<Integer,String > myHashMap = new HashMap<Integer, String>(10,0.5f);
        String key = "tao";
        //int i = key.hashCode();  //‭114595: 0000 0000 0000 0001 1011 1111 1010 0011   右移16位:0000 0000 0000 0000 0000 0000 0000 0001
        System.out.println("原来的："+ key.hashCode());
        System.out.println(key.hashCode()>>>16);
        int hash = hash(key);      //‭114594:  0000 0000 0000 0001 1011 1111 1010 0010
        int place = hash & 15;
        System.out.println("处理过后的："+ hash);
        System.out.println(place);
    }
    @Test
    public  void ConcurrentHashMapStudy(){
        ConcurrentHashMap map  = new ConcurrentHashMap();
    }
}
