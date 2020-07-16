package com.neusoft.bsp.System.vo;

import com.neusoft.bsp.System.entity.Menu;
import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.common.base.BaseModelJson;

import java.util.List;

public class UserLoginJson extends BaseModelJson<User> {
    public List<Menu> menu;
    @Override
    public String toString() {
        return "UserLoginJson{" +
                "menu=" + menu +
                ", data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
