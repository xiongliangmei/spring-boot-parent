package com.xiongliangmei;

import com.xiongliangmei.dao.UserRepository;
import com.xiongliangmei.entity.User;
import org.apache.lucene.search.Sort;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElstaticsearchApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;



    @Test
    public void contextLoads() {
        User user = new User();
        user.setId("2");
        user.setUsername("小美");
        user.setPassword("123213");
        userRepository.save(user);
    }

    /***
     * 查询所有
     */
    @Test
    public void  find(){
       Iterable<User> list =  userRepository.findAll();

       list.forEach(item->{
           System.out.println(item.getUsername());
       });
    }

    /****
     * 分页
     * @throws Exception
     */
    @Test
    public void  findByName() throws Exception{

        Pageable pageable = PageRequest.of(0,5);
        Page<User> page  = userRepository.findAll(pageable);

        page.forEach(item-> System.out.println(item.getUsername()));

    }

    //添加搜索条件
    @Test
    public void search(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //结果过滤 ctrl + p 可以看需要传入的参数类型 第一个数组类型是需要包含的  第二个参数是不包含的
        /*queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{"id","title","price"},null));*/
        //添加查询条件
        NativeSearchQueryBuilder query = queryBuilder.withQuery(QueryBuilders.matchQuery("username", "熊亮"));
        //MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", "小米手机");
        //
        Page<User> page = userRepository.search(query.build());

        page.forEach(item->{
            System.out.println(item.getUsername());
        });
    }
    @Test
    public void searchBy(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        NativeSearchQueryBuilder query = queryBuilder.withQuery(QueryBuilders.matchQuery("username", "熊亮"));
    }

}
