package jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCTest {
    @Test
    public void test00()throws Exception{
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("", "", "");  //获取数据连接
            conn.setAutoCommit(false); // 关闭自动提交机制
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);//设置数据隔离级别

            Statement statement = conn.createStatement();
            statement.executeUpdate("update语句1"); //更新语句1
            statement.executeUpdate("update语句2"); //更新语句2

            conn.commit();   // 提交事务
        }catch (Exception e){
            conn.rollback();
        }finally {

        }
    }


    /**
     * 发生异常回到回滚点2
     * @throws Exception
     */
    @Test
    public void test01()throws Exception{
        Connection conn = null;
        Savepoint pointTwo = null;
        try{
            conn = DriverManager.getConnection("", "", "");  //获取数据连接
            conn.setAutoCommit(false); // 关闭自动提交机制
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);//设置数据隔离级别

            Statement statement = conn.createStatement();
            Savepoint pointOne = conn.setSavepoint("point_1");
            statement.executeUpdate("update语句1"); //更新语句1

            pointTwo = conn.setSavepoint("point_2");
            statement.executeUpdate("update语句2"); //更新语句2

            conn.commit();   // 提交事务
        }catch (Exception e){
            conn.rollback(pointTwo);
        }finally {

        }
    }
}
