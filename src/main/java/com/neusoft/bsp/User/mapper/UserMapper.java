package com.neusoft.bsp.User.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.User.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<String, User> {

}
