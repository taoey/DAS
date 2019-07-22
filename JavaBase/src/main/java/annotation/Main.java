package annotation;

import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        // 获取所有类
        String servicePackage = "annotation.annopackage";
        List<String> serviceList = ClassUtils.scanClass(servicePackage);

        //解析类名上的所有方法
        for (String className : serviceList){
            Class<?> aClass = Class.forName(className);
            //获取类的所有方法
            Method[] methods = aClass.getMethods();
            for(Method method:methods){
                MethodExplain explain = method.getAnnotation(MethodExplain.class);
                //输出注解相关
                if (explain!=null){
                    System.out.println(explain.title());
                }
            }
        }

    }
}
