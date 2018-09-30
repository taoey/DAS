package object;

import org.junit.Test;

public class Main {

    @Test
    public void equalsTest(){
        Object a = new Object();
        Object b = new Object();
        boolean result = a.equals(b);
        System.out.println(result);

    }

    @Test
    public void hashCodeTest(){
        Object a = new Object();
        a.hashCode();
    }

    @Test
    public void equalTest01(){
        int b= 118;
        int c =10;
        Integer d =10;  //自动装箱生成 Integer对象
        Integer e = 128;
        Integer f = 128;
        int g =128;
        System.out.println(c==d);//true, 拆箱比较，比较的是数值
        System.out.println(e==f);//false, 两个对象比较，比较的是引用
        System.out.println(e==(b+c));//true, 存在表达式，比较的是数值
    }
}
