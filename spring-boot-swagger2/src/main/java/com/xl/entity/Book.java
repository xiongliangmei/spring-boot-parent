package com.xl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "返回响应数据")
@Data
public class Book {
    @ApiModelProperty(value = "书籍名称")
    private String name;
    @ApiModelProperty(value = "书籍编码")
    private String id;
}
