package MyBTree;

import java.util.List;

/**
 * B树需要包含的方法：
 * 	insert()   :插入一个值到B树中、
 * 	remove()   :从B树中删除一个值
 * 	search()   :从B树中查找一个值
 *  solveOverfolw()  :因插入而上溢后的分裂处理
 *  solveUnderflow() :因删除而下溢后的合并处理
 *  print()          :打印一个B树，用于调试
 *
 */
public class MyBTree<K,V> {
    /**
     * B树单个节点存储的是K，V键值对
     * 只要记住Entry类中只有Key，Value即可（POJO）
     * @param <K>
     * @param <V>
     */
    private class Entry<K,V>{
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    private class BTNode<K,V>{
        private List<Entry<K,V>> entrys; //按照K进行升序排列
        private List<Entry<K,V>> childs; //孩子向量，其值总比entrys多1
        private boolean leaf;          //是否为叶子节点
        private Comparable<K> kComparator; //键的比较函数

    }
    private static final int DEFAULT_KEYNUM=2;  //
    // 的数量默认为2
    private BTNode<K,V> root;                   //根节点
    private int keyNum = DEFAULT_KEYNUM;        //关键码的数量  如果是一个m阶B树，那关键码的数量为[ceil((m-1)/2),m-1]
    //private int minKeySize = keyNum
}
