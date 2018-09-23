package classStudy;

import org.junit.Test;

class MyCat{
    public static  String name1 ="cat1";
    public static final String name2 = "cat2";
    static {
        System.out.println("static代码块");
    }
    {
        System.out.println("普通代码块");
    }
    public MyCat(){
        System.out.println("我是构造函数");
    }
    public static void show(){
        System.out.println("我是show方法");
    }
    public static final void show2(){
        System.out.println("我是show2方法");
    }
}
public class ClassLoader {
    @Test
    public void test00(){
        String a = "abc";
        String b = "abc";
        final String d = "abc";
        String c = new String("abc");


        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(b==d);
    }

    @Test
    public void test01(){
        System.out.println(MyCat.name1);
        //System.out.println(MyCat.name2);
        //MyCat.show();
        //MyCat.show2();
       // System.out.println("--------------------------");

        //MyCat hv = new MyCat();
        //MyCat bai = new MyCat();
        //System.out.println("--------------------------");


    }
}
