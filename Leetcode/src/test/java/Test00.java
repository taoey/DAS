class Student{
    public String name;
    public int age;

}
public class Test00 {
    public static void main(String[] args) {
        Student s = new Student();
        s.age=10;
        s.name="tao";
        s.age=s.age+1;
        System.out.println(s.age);

    }
}
