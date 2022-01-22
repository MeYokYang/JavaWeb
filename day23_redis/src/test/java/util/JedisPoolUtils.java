package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool工具类
 * 加载配置文件，配置连接池的参数
 * 提供获取连接的方法
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;

    static {

        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties p = new Properties();
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(p.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(p.getProperty("maxIdle")));

        jedisPool = new JedisPool(jedisPoolConfig, p.getProperty("host"), Integer.parseInt(p.getProperty("port")));

    }

    /**
     * 获取连接的方法
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

}
