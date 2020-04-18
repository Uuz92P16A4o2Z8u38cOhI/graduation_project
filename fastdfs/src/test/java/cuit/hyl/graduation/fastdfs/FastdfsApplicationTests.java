package cuit.hyl.graduation.fastdfs;

import cuit.hyl.graduation.fastdfs.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class FastdfsApplicationTests {

    @Autowired
    private  RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {

    }

    @Test
    void testRedis(){
        boolean i = redisUtils.set("111", "1111");
        System.out.println(i);
//        redisTemplate.opsForValue().set("111", 111);
    }
}
