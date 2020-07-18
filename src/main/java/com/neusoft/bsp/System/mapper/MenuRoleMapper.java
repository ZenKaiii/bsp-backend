package com.neusoft.bsp.System.mapper;

import com.neusoft.bsp.System.entity.Menu;
import com.neusoft.bsp.System.entity.Role;
import com.neusoft.bsp.System.entity.MenuTree;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuRoleMapper{
    int insertMenu(Menu menu);
    int insertRole(Role role);

    int deleteMenu(int menu_id);
    int deleteRole(int role_id);

    int updateMenu(Menu menu);
    int updateRole(Role role);

    List<Menu> getAllMenus();
    List<Role> getAllRoles();

    List<Menu> getRoleMenus(int role_id);

    int deleteRoleMenu(int role_id);
    int setRoleMenu(Map<String,Object> rolemenu);

    String getRoleById(int role_id);

    List<MenuTree> getMenuTree();

    List<MenuTree> getRoleMenuTree(int role_id);

    int[] getRoleMenuIds(int role_id);
}
