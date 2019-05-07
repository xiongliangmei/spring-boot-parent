package com.xiongliang.service;

import com.xiongliang.entity.Author;

import java.util.List;

public interface IAuthorService {

    /***
     * 用户详情
     * @param id
     * @return
     */
    Author getAuthor(String id);
}
