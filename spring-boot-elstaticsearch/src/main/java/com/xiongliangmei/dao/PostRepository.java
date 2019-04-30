package com.xiongliangmei.dao;

import com.xiongliangmei.entity.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostRepository  extends ElasticsearchRepository<Post,String> {
}
