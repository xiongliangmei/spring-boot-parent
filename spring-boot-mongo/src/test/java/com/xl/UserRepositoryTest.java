package com.xl;

import com.xl.dao.UserRepository;
import com.xl.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends SpringBootMongoApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void init(){


    }

}
