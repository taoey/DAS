package lombok;

import org.junit.Test;

public class App {

    @Test
    public void test01(){
        StudentA s1 = new StudentA();
        s1.setId(1);
        s1.setName("tao");
        s1.setAge(20);
        System.out.println(s1);
    }

    @Test
    public void test02(){
        StudentB s1 = new StudentB();
        s1.setId(2).setName("tao").setAge(20);
        System.out.println(s1);
    }

    @Test
    public void test03(){
        StudentC s = StudentC.builder()
                .id(3)
                .age(20)
                .name("tao")
                .build();
        System.out.println(s);
    }

}
