package learn.web.base_sa.data.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * 有关redis的操作，必须继承此类
 * Created by Vigo on 17/2/23.
 */
public class RedisBase<K, V> {

    @Autowired
    protected RedisTemplate<K, V> redisTemplate;

    public RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }
}
