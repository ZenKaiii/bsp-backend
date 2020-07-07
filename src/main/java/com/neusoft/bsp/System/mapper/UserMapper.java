package com.neusoft.bsp.System.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.System.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<String, User> {

}
