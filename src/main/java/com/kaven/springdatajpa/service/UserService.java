package com.kaven.springdatajpa.service;

import com.kaven.springdatajpa.entity.User;
import com.kaven.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: spring-data-jpa
 * @description:
 * @author: Kaven
 * @create: 2018-11-16 12:57
 **/

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    /**
     * 事务处理
     * 两个用户只能同时添加成功，或者同时添加失败
     * */
    @Transactional
    public void insertTwo() {
        User UserA = new User();
        UserA.setAge(19);
        UserRepository.save(UserA);

        User UserB = new User();
        UserB.setAge(22);
        UserRepository.save(UserB);
    }

    /**
     * 根据用户 id 来获取用户的年龄信息
     * */
    public Integer getAge(Integer id) throws Exception {
        User User = UserRepository.findById(id).get();
        Integer age = User.getAge();
        return age;
    }

    /**
     * 根据用户 id 来获取用户
     * */
    public User findOne(Integer id) {
        return UserRepository.findById(id).get();
    }
}
