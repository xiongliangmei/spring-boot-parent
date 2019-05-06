package com.xiongliang.dao;

import com.xiongliang.entity.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostRepository  extends ElasticsearchRepository<Post,String> {
}
