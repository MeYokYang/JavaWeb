import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import util.JedisPoolUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试类
 */
public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);

        //2.操作
        jedis.set("username", "haha");

        //3.关闭连接
        jedis.close();
    }

    @Test
    public void test2(){

        Jedis jedis = new Jedis(); //空参则是默认值

        jedis.set("username", "haha");
        String username = jedis.get("username");
        System.out.println(username);

        //将activeCode hehe键值对存入redis，并且在20秒后自动删除
        jedis.setex("activeCode", 20, "hehe");


        jedis.close();
    }

    @Test
    public void test3(){

        Jedis jedis = new Jedis();

        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "male");
        String name = jedis.hget("user", "name");
        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");
        System.out.println(user);

        jedis.close();
    }

    @Test
    public void test4(){

        Jedis jedis = new Jedis();

        jedis.lpush("myList", "a", "b", "c");
        jedis.rpush("myList", "a", "b", "c");

        List<String> myList = jedis.lrange("myList", 0, -1);
        System.out.println(myList);

        String element1 = jedis.lpop("myList");
        String element2 = jedis.rpop("myList");

        System.out.println(element1);
        System.out.println(element2);

        List<String> myList2 = jedis.lrange("myList", 0, -1);
        System.out.println(myList2);

        jedis.close();
    }

    @Test
    public void test5(){

        Jedis jedis = new Jedis();

        jedis.sadd("mySet", "Java", "php", "c++");

        Set<String> mySet = jedis.smembers("mySet");
        System.out.println(mySet);

        jedis.close();
    }

    @Test
    public void test6(){

        Jedis jedis = new Jedis();

        jedis.zadd("mySortedset", 3, "ya");
        jedis.zadd("mySortedset", 4, "la");
        jedis.zadd("mySortedset", 2, "ta");

        Set<String> mySortedset = jedis.zrange("mySortedset", 0, -1);
        System.out.println(mySortedset);

        jedis.close();
    }

    @Test
    public void test7(){
        //0.创建一个配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);

        //1.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);
//        JedisPool jedisPool = new JedisPool();

        //2.获取连接
        Jedis jedis = jedisPool.getResource();

        //3.使用
        jedis.set("hehe", "hah1a");

        //4.关闭
        jedis.close();

    }

    @Test
    public void test8(){

        Jedis jedis = JedisPoolUtils.getJedis();

        //3.使用
        jedis.set("hehe", "hah1a2");

        //4.关闭
        jedis.close();

    }

}
