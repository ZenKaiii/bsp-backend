package com.neusoft.bsp.System.service.impl;

import com.neusoft.bsp.System.entity.Menu;
import com.neusoft.bsp.System.entity.Role;
import com.neusoft.bsp.System.mapper.MenuRoleMapper;
import com.neusoft.bsp.System.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MenuRoleServiceImpl implements MenuRoleService {

    @Autowired
    MenuRoleMapper menuRoleMapper;

    @Override
    public int insertMenu(Menu menu) { return menuRoleMapper.insertMenu(menu); }

    @Override
    public int insertRole(Role role) {
        return menuRoleMapper.insertRole(role);
    }

    @Override
    public int deleteMenu(Menu menu) {
        return 0;
    }

    @Override
    public int deleteRole(Role role) {
        return 0;
    }

    @Override
    public int updateMenu(Menu menu) {
        return 0;
    }

    @Override
    public int updateRole(Role role) {
        return 0;
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRoleMapper.getAllMenus();
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public List<Menu> getRoleMenus(int role_id) {
        return null;
    }

}
