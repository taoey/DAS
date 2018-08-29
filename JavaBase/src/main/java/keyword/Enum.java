package keyword;

/**
 * 枚举类型可以当做是一个Static类来使用
 */


//定义枚举类型
enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
public class Enum {
    private Day day;  //注意声明的数据类型是Day，而不是int类型的

    public  Enum(){
        day = Day.FRIDAY;
    }

    public static void main(String[] args) {
        Day friday = Day.FRIDAY;
        System.out.println(friday);
    }
}
