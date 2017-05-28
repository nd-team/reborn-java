package com.bjike.reborn.user.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.user.dto.UserDTO;
import com.bjike.reborn.user.entity.User;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: [用户持久化接口, 继承基类可使用ｊｐａ命名查询]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserRep extends JpaRep<User, UserDTO> {
    /**
     * 此处使用的是spring-data-jpa接口,不需要对接口进行实现,jpa可根据命名自动进行数据的查询
     * jpa接口规范：http://docs.spring.io/spring-data/jpa/docs/1.11.0.M1/reference/html/
     * <p>
     * /**
     * 通过用户名和密码查找用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Cacheable("userDaoCache")
    User findByUsernameAndPassword(String username, String password);

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return
     */
    User findByUsername(String username);




}
