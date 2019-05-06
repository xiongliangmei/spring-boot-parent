package com.xiongliang.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "poetry",type = "post",indexStoreType = "fs"/*,shards = 5,replicas = 1,refreshInterval = "-1"*/)
@Data
public class Post {

    @Id
    private String id;
    private String title;
    private String content;
    private int userId;
    private int weight;

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", weight=" + weight +
                '}';
    }
}
