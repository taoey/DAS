package reflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
    private  String name;
    private  int age;
    private  int sex;
    public Student(){
        this.name="2B";
        this.age=0;
        this.sex=1;
    }

    public Student(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * 获取学生的名字
     * @return
     */
    public String getName(){
        System.out.println("getName被执行了");
        return this.name;
    }

}
public class Reflection1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String className = "reflection.Student";
        String methodName = "getName";


        Class<?> student = Class.forName(className);  //获取类
        Object obj = student.newInstance();           //根据类实例化出对象
        student.getFields();
        Method method = student.getMethod(methodName);//获取想要执行的方法
        Object methodReturn = method.invoke(obj);     //让某个对象执行这个方法
        System.out.println(methodReturn);             //输出该方法返回的值

    }
}
