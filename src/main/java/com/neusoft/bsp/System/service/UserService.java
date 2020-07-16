package com.neusoft.bsp.System.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int insert(User user);

    int update(User user);

    int delete(int userid);


    User getById(int userid);

    List<User> getAll();

    List<User> getAllByFilter(Map<String,Object> map);

    PageInfo<User> getAllByFilter(Integer pageNum,Integer pageSize);

    PageInfo<User> getAllByFilter(Integer pageNum,Integer pageSize,Map<String,Object> map);

    User getUserByName(String username);
}
