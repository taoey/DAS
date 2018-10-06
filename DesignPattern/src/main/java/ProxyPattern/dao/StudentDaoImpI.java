package ProxyPattern.dao;

/**
 * 学生dao实体类
 */
public class StudentDaoImpI implements IstudentDao {
    @Override
    public void add(Integer student) {
        System.out.println("添加学生......");
    }

    @Override
    public void del(Integer sid) {
        System.out.println("删除学生......");
    }
}
