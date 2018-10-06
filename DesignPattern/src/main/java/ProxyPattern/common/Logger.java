package ProxyPattern.common;

import org.junit.Test;

import java.util.Date;

/**
 * 日志记录器
 */
public class Logger {

    public void log(String uid){
        Date date = new Date();
        System.out.println(date.toString()+" : "+uid+"更新了数据库");
    }

    @Test
    public void test00(){
        log("tao");
    }
}
