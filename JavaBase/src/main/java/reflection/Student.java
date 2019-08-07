package reflection;

public class Student {
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
