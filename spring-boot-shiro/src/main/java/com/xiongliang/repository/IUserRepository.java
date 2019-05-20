package com.xiongliang.repository;

import com.xiongliang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,String> {

    User findByUsername(String username);
}
