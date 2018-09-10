package keyword;

/**
 * Created by tao on 2018/9/8.
 *
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 定义一个猫咪类，猫咪拥有两个属性，name和age
 */
class Cat{
    private String name;
    private Integer age;

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Comparator {

    @Test
    public void test00(){
        List<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat("cat1",3));
        cats.add(new Cat("cat2",1));
        cats.add(new Cat("cat3",5));

        //Cat 升序排列
        Collections.sort(cats, new java.util.Comparator<Cat>() {
            public int compare(Cat o1, Cat o2) {
                return o1.getAge() - o2.getAge() ; //第一个对象在前是升序，第二个对象在前是降序
            }
        });
        System.out.println(cats);

        //Cat 降序排列
        Collections.sort(cats, new java.util.Comparator<Cat>() {
            public int compare(Cat o1, Cat o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        System.out.println(cats);

    }
}
