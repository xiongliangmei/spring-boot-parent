package com.xiongliangmei;

import com.xiongliangmei.dao.UserRepository;
import com.xiongliangmei.entity.User;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.List;

public class UserRepositoryTest extends SpringBootElstaticsearchApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void findByUsername(){
        List<User> user = userRepository.findByUsername("熊亮");

        user.forEach(item->{
            System.out.println(item.getUsername());
        });
    }

    /***
     * 自定义查询
     */
    @Test
    public void SelectByUsername(){
        User user = userRepository.SelectByUsername("熊亮");

        System.out.println(user.getUsername());
    }

/*    *//**
     * 自定查询根据id
     *//*
    @Test
    public void selectById(){
        User user = userRepository.selectById("1");
        System.out.println(user.getUsername());
    }*/
}
