/*package com.xiongliang.redis;

import com.xiongliang.SpringBootRedisApplicationTests;
import com.xiongliang.entity.Author;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class Test extends SpringBootRedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisHelper redisHelper;


    @org.junit.Test
    public void test(){
  *//*     stringRedisTemplate.opsForValue().set("aaa","1111");*//*
*//*        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));*//*
*//*        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));*//*
        Author author = new Author();
        author.setId("1");
        author.setName("熊亮");
        author.setIntro_l("不会打篮球的程序不是好男人");
        redisHelper.valuePut("bbb",author);
        System.out.println(redisHelper.getValue("bbb"));
    }

    @org.junit.Test
    public void testObj()throws Exception{
        Author author = new Author();
        author.setName("Jerry");
        author.setId("2");
        author.setIntro_l("我是誰，我在那裏");

        ValueOperations<String,Author> operations =redisTemplate.opsForValue();
        operations.set("502",author);
        Thread.sleep(500);
        boolean exists = redisTemplate.hasKey("502");
        if (exists){
            System.out.println(redisTemplate.opsForValue().get("502"));
        }else{
            System.out.println("exists is false");
        }
    }
}*/
