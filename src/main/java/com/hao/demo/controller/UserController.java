package com.hao.demo.controller;

import com.hao.demo.dao.UserMapper;
import com.hao.demo.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public List<User> list(){
        List<User> list =  userMapper.selectAll();
        return list;
    }
    @PostMapping("/users")
    public int create(@RequestBody User user ){
        userMapper.create(user);
        return 1;
    }

    @DeleteMapping("/users/{id}")
    public int delete(@PathVariable("id") int id){

        int res = userMapper.delete(id);
        return res;
    }
    @PatchMapping("/users/{id}")
    public int update(@PathVariable("id") int id, @RequestBody User user){
        System.out.println(id);
        System.out.println(user);
        userMapper.update(id,user);
        return 1;
    }



}
