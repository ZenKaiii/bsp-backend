package com.neusoft.bsp.System.service.impl;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.Menu;
import com.neusoft.bsp.System.entity.Role;
import com.neusoft.bsp.System.service.MenuRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("menuroleService")
public class MenuRoleServiceImpl implements MenuRoleService {
    @Override
    public int insertMenu(Menu menu) {
        return 0;
    }

    @Override
    public int insertRole(Role role) {
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
    public int deleteMenu(Menu menu) {
        return 0;
    }

    @Override
    public int deleteRole(Role role) {
        return 0;
    }

    @Override
    public Menu getMenuById(int id) {
        return null;
    }

    @Override
    public Role getRoleById(int id) {
        return null;
    }

    @Override
    public Menu getMenuByName(String name) {
        return null;
    }

    @Override
    public Role getRoleByName(String name) {
        return null;
    }

    @Override
    public List<Menu> getAllMenusByFilter(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Role> getAllRolesByFilter(Map<String, Object> map) {
        return null;
    }
}
