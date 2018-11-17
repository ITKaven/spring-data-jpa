package com.kaven.springdatajpa.controller;

import com.kaven.springdatajpa.entity.User;
import com.kaven.springdatajpa.repository.UserRepository;
import com.kaven.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring-data-jpa
 * @description: 用户操作控制器
 * @author: Kaven
 * @create: 2018-11-16 12:53
 **/

@RestController
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private UserService UserService;

    /**
     * 获取所有用户信息
     * */
    @GetMapping(value = "/users")
    public List<User> Users() {
        return UserRepository.findAll();
    }

    /**
     * 添加用户
     * */
    @PostMapping(value = "/user/add")
    public User addUser(User User) {
        return UserRepository.save(User);
    }

    /**
     * 根据用户 id 获取用户信息
     * */
    @PostMapping(value = "/user/get")
    public User getUser(@RequestParam("id") Integer id) {
        return UserRepository.findById(id).get();
    }

    /**
     * 更新用户信息
     * */
    @PutMapping(value = "/update")
    public void updateUser(@RequestParam("id") Integer id ,
                           @RequestParam("age") Integer age) {
        UserRepository.updateUser(id , age);
    }

    /**
     * 删除用户信息
     * */
    @DeleteMapping(value = "/user/delete")
    public void UserDelede(@RequestParam("id") Integer id) {
        UserRepository.deleteById(id);
    }

    /**
     * 通过用户年龄查询用户列表
     * */
    @GetMapping(value = "/users/findbyage")
    public List<User> UserListByAge(@RequestParam("age") Integer age) {
        return UserRepository.findByAge(age);
    }

    /**
     * 同时添加两个用户（只能同时添加成功或者同时添加失败）
     * */
    @PostMapping(value = "/users/inserttwo")
    public void insertTwoUsers() {
        UserService.insertTwo();
    }

    /**
     * 通过用户 id 获取用户的年龄
     */
    @GetMapping(value = "/user/id")
    public Integer getAge(@RequestParam("id") Integer id) throws Exception {
        return UserService.getAge(id);
    }
}