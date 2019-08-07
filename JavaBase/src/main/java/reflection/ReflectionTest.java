package reflection;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ReflectionTest {


    @Test
    public void test00() throws Exception{
        String className = "reflection.Student"; //包名+类名
        String methodName = "getName";           //方法名


        Class<?> student = Class.forName(className);  //获取类
        Object obj = student.newInstance();           //根据类实例化出对象
        Field[] fields = student.getDeclaredFields();
        Method method = student.getMethod(methodName);//获取想要执行的方法
        Object methodReturn = method.invoke(obj);     //让某个对象执行这个方法
        System.out.println(methodReturn);             //输出该方法返回的值

    }


    @Test
    public void test01(){
        Class<Student> studentClass = Student.class;
        System.out.println(JSONObject.toJSON(studentClass));
    }
}
