package com.xiongliang.redis;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface RedisHelper<HK,T> {

    /***
     * Hash 结构 添加元素
     * @param key
     * @param hashKey
     * @param domain
     */
    void hashPut(String key,HK hashKey,T domain);

    /***
     * Hash 结构 获取指定key 所有值
     * @param key
     * @return
     */
    Map<HK,T> hashFindAll(String key);

    /***
     * Hash 结构 获取单个元素
     * @param key
     * @param hashKey
     * @return
     */
    T hashGet(String key,HK hashKey);


    void hashRemove(String key,HK hashKey);

    /***
     *  List 结构 向尾部（Right）添加元素
     * @param key
     * @param domain
     * @return
     */
    Long listPush(String key,T domain);

    /***
     * List 结构 向头部（Left）添加元素
     * @param key
     * @param domain
     * @return
     */
    Long listUnshift(String key,T domain);

    /***
     * List 结构 获取所有元素
     * @param key
     * @return
     */
    List<T>  listFindAll(String key);

    /***
     * List 结构 移除并取数组第一个元素
     * @param key
     * @return
     */
    T listPop(String key);

    /***
     * 对象的实体类
     * @param key
     * @param domain
     */
    void valuePut(String key,T domain);

    /***+
     * 获取对象实体类
     * @param key
     * @return
     */
    T getValue(String key);

    void remove(String key);

    /***
     * 设置过期时间
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    boolean expirse(String key, long timeout, TimeUnit timeUnit);
}
