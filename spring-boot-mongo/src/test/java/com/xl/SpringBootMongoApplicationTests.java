package com.xl;

import com.xl.dao.LocationRepository;
import com.xl.dao.UserRepository;
import com.xl.entity.Location;
import com.xl.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.EAN;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootMongoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void contextLoads() {


         userRepository.save(new User("2L", "mama", 40));
               userRepository.save(new User("3L", "kaka", 50));
              userRepository.save(new User("4L", "didi2", 30));
             userRepository.save(new User("5L", "mama", 40));
             userRepository.save(new User("6L", "kaka2", 50));
              userRepository.save(new User("7L", "kaka", 50));
         userRepository.save(new User("8L", "kao", 50));
             userRepository.save(new User("9L", "ekakae", 50));
             userRepository.save(new User("10L", "kaka5", 50));
           userRepository.save(new User("11L", "", 50));
                userRepository.save(new User("12L", null, 50));

    }
    @Test
    public void  test(){
       List<User> list = userRepository.findByUsernameLike("kaka");

       log.info("名称是{}",list.toString());
    }


    @Test
    public void  test1(){
        Pageable pageable = new  PageRequest(0,5);

       Page<User> page =  userRepository.findByNameAndAgeRang("kaka",50,pageable);

        log.info("名称是{}",page.getTotalElements());
    }

    @Test
    public void  init(){
        mongoTemplate.indexOps(Location.class).ensureIndex(new GeospatialIndex("position"));
        // 初始化数据
        mongoTemplate.save(new Location("天安门", 116.4041602659, 39.9096215780));
        mongoTemplate.save(new Location("东单", 116.4244857287, 39.9144951360));
        mongoTemplate.save(new Location("王府井", 116.4177807251, 39.9175129885));
        mongoTemplate.save(new Location("西单", 116.3834863095, 39.9133467579));
        mongoTemplate.save(new Location("复兴门", 116.3631701881, 39.9129554253));
        mongoTemplate.save(new Location("复兴门", 116.3631701881, 39.9129554253));

        mongoTemplate.save(new Location("西四", 116.3799838526, 39.9299098531));
        mongoTemplate.save(new Location("菜市口", 116.3809950293, 39.8952009239));
        mongoTemplate.save(new Location("东四", 116.4239387439, 39.9306126797));
    }

    @Test
    public void  test111(){
       List<Location> list = locationRepository.findCircleNear(new Point(116.4041602659, 39.9096215780),3/111);

       list.forEach(location -> {
           System.out.println(location.toString());
           log.info(location.toString());
       });
    }

    /**
     * 查找左下角是菜市口，右上角是东四，这个方形区域内的所有点
     */
    @Test
    public void findBoxNearTest() {
        Point point1 = new Point(116.3809950293, 39.8952009239);
        Point point2 = new Point(116.4239387439, 39.9306126797);
        List<Location> locations = locationRepository.findBoxWithin(point1, point2);
        locations.forEach(location -> {
            System.out.println(location.toString());
            log.info(locations.toString());
        });
    }





}
