package com.xiongliang.controller;

import com.xiongliang.entity.Author;
import com.xiongliang.service.IAuthorService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/poem")
public class AuthorController {

    @Autowired
    IAuthorService authorService;

    @GetMapping("/getAuthor")
    public Author getAuthor(String id){
        return authorService.getAuthor(id);
    }
    

}
