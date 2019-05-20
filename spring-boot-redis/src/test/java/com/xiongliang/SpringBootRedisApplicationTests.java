package com.xiongliang;

import com.xiongliang.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    public static Logger logger = LoggerFactory.getLogger(SpringBootRedisApplicationTests.class);
    @Autowired
    RedisDao redisDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public  void testRedis(){
        redisDao.setKey("name","xiongliang");
 /*       redisDao.setKey("age","11");*/
        redisDao.setKey("age","熊亮");
        logger.info(redisDao.getKey("name"));
        logger.info(redisDao.getKey("age"));
    }
}
