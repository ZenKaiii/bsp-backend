package com.neusoft.bsp.System.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.Menu;
import com.neusoft.bsp.System.entity.Role;
import java.util.List;
import java.util.Map;

public interface MenuRoleService {

    int insertMenu(Menu menu);
    int insertRole(Role role);

    int updateMenu(Menu menu);
    int updateRole(Role role);

    int deleteMenu(Menu menu);
    int deleteRole(Role role);

    Menu getMenuById(int id);
    Role getRoleById(int id);

    Menu getMenuByName(String name);
    Role getRoleByName(String name);

    List<Menu> getAllMenusByFilter(Map<String,Object> map);
    List<Role> getAllRolesByFilter(Map<String,Object> map);


}
