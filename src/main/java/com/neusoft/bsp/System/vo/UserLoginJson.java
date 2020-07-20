package com.neusoft.bsp.System.vo;

import com.neusoft.bsp.System.entity.Menu;
import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.common.base.BaseModelJson;

import java.util.Arrays;
import java.util.List;

public class UserLoginJson extends BaseModelJson<User> {
    public List<Menu> menu;
    public int role_id;
    public int user_id;
    public String token;

}
