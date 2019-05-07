package com.xiongliang.service.impl;

import com.xiongliang.entity.Author;
import com.xiongliang.service.IAuthorService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements IAuthorService {


    @Cacheable(value = "authorcache",key = "#p0")
    @Override
    public Author getAuthor(String id) {
        Author author = new Author();
        author.setName("xiaoma");
        author.setId("1235");
        author.setIntro_l("这是小马");
        return author;
    }

    @CachePut(value = "authorcache",key = "#p0")
    public Author updateAuthor(String id){
        Author author = new Author();
        author.setName("xiaoma");
        author.setId("1235");
        author.setIntro_l("这是x");
        return author;
    }

    @CacheEvict
    public void insert(){}
}
