package com.hao.demo.dao;

import com.hao.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    void create(User user);
    int delete(int id);
    void update(@Param("id") int id,@Param("user") User user);

}
