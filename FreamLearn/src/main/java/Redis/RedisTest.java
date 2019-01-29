package Redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {

    /**
     * redis 连接远程设置
     */
    @Test
    public void init(){
        Jedis jedis = new Jedis("123.207.155.241");
        jedis.auth("tao");
        jedis.set("myredis","ok");
        System.out.println(jedis.get("myredis"));
    }
}
