package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    public int insert(User user);
    List<User> getUserList();
    Optional<User> getUserByUserId(Integer userId);

    int editUser(User user); // mapper에서 언급한 유저객체 필요

    int removeUser(Integer userId);
}
