import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

public class jedisTest {
       public static void main(String agrs[]) {
              Jedis jedis = new Jedis("47.107.238.158", 6379);
              GenericObjectPoolConfig config=new GenericObjectPoolConfig();
              JedisPool pool = new JedisPool(config,"47.107.238.158", 6379);
              Jedis jedis1=pool.getResource();
              Pipeline pipeline=jedis1.pipelined();
       }

}
