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
    public int deleteMenu(int menu_id) {
        return menuRoleMapper.deleteMenu(menu_id);
    }

    @Override
    public int deleteRole(int role_id) {
        return menuRoleMapper.deleteRole(role_id);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuRoleMapper.updateMenu(menu);
    }

    @Override
    public int updateRole(Role role) {
        return menuRoleMapper.updateRole(role);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRoleMapper.getAllMenus();
    }

    @Override
    public List<Role> getAllRoles() {
        return menuRoleMapper.getAllRoles();
    }

    @Override
    public List<Menu> getRoleMenus(int role_id) {
        return menuRoleMapper.getRoleMenus(role_id);
    }

    @Override
    public int setRoleMenu(Map<String,Object> rolemenu) {
//        int role_id = (int)(rolemenu.get("role"));
//        List<Menu> step1 = menuRoleMapper.getRoleMenus(role_id);
//        int delete_step = menuRoleMapper.deleteRoleMenu(role_id);
//        if(delete_step == 1){
//            int set_step = menuRoleMapper.setRoleMenu(rolemenu);
//            if(delete_step == 1){
//                return 1;
//            }else{
//                for(Menu menu: step1){
//                    menuRoleMapper.insertMenu(menu);
//                }
//                return 0;
//            }
//        }else{
//            return 0;
//        }
        return menuRoleMapper.setRoleMenu(rolemenu);
    }

    @Override
    public int deletRoleMenu(int role_id) {
        return menuRoleMapper.deleteRoleMenu(role_id);
    }

    @Override
    public String getRoleById(int role_id) {
        return menuRoleMapper.getRoleById(role_id);
    }

}
