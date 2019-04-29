package com.xiongliangmei.dao;

import com.xiongliangmei.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.stream.Stream;

public interface UserRepository extends ElasticsearchRepository<User,String>/*, PagingAndSortingRepository<User,String>*/ {

/*    @Query("SELECT u FROM User u WHERE u.name = #{name}")
    Stream<User> findByName(String name);*/

    /***
     * 分页
     * @param pageable
     * @return
     */
    Page<User> findAll(Pageable pageable);

}
