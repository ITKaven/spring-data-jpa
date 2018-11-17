package com.kaven.springdatajpa.repository;

import com.kaven.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: spring-data-jpa
 * @description:
 * @author: Kaven
 * @create: 2018-11-16 13:04
 **/
@Component
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 通过年龄来查询用户列表，根据 spring data jpa 的命名规则来命名方法名
     */
    public List<User> findByAge(Integer age);

    /**
     * 更新用户
     * */
    @Transactional
    @Modifying
    @Query(value = "update user bean set bean.age=?2 where bean.id=?1")
    public void updateUser(Integer id , Integer age);
}

