package com.neusoft.bsp.System.mapper;

import com.neusoft.bsp.System.entity.Menu;
import com.neusoft.bsp.System.entity.Role;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuRoleMapper{
    int insertMenu(Menu menu);
    int insertRole(Role role);

    int deleteMenu(Menu menu);
    int deleteRole(Role role);

    int updateMenu(Menu menu);
    int updateRole(Role role);

    List<Menu> getAllMenus();
    List<Role> getAllRoles();

    List<Menu> getRoleMenus(int role_id);
}
