package com.neusoft.bsp.controller;


import com.neusoft.bsp.System.entity.Menu;
import com.neusoft.bsp.System.entity.Role;
import com.neusoft.bsp.System.service.MenuRoleService;
import com.neusoft.bsp.System.vo.MenuListJson;
import com.neusoft.bsp.System.entity.MenuTree;
import com.neusoft.bsp.System.vo.RoleListJson;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/menurole")
public class MenuRoleController extends BaseController {

    @Autowired
    MenuRoleService menuRoleService;

    @RequiresPermissions("menu:menulist")
    @GetMapping("/menulist")
    public MenuListJson getMenuList() {
        MenuListJson result = new MenuListJson();
        result.code = 200;
        result.message = "fetch success";
        result.data = menuRoleService.getAllMenus();
        return result;
    }

    @GetMapping("/menutree")
    public BaseModelJson<List<MenuTree>> getMenuTree() {
        BaseModelJson<List<MenuTree>> result = new BaseModelJson<List<MenuTree>>();
        result.code = 200;
        result.message = "fetch success";
        result.data = menuRoleService.getMenuTree();
        return result;
    }

    @GetMapping("/menutreerole")
    public BaseModelJson<List<MenuTree>> getRoleMenuTree(@RequestParam int role_id) {
        BaseModelJson<List<MenuTree>> result = new BaseModelJson<List<MenuTree>>();
        result.code = 200;
        result.message = "fetch success";
        result.data = menuRoleService.getRoleMenuTree(role_id);
        return result;
    }

    @RequiresPermissions("menu:menulist")
    @GetMapping("/getRoleMenulist")
    public MenuListJson getRoleMenuList(@RequestParam int role_id) {
        MenuListJson result = new MenuListJson();
        result.code = 200;
        result.message = "fetch success";
        result.data = menuRoleService.getRoleMenus(role_id);
        return result;
    }

    @GetMapping("/getRoleMenuIds")
    public BaseModelJson<int[]> getRoleMenuIds(@RequestParam int role_id) {
        BaseModelJson<int[]> result = new BaseModelJson<int[]>();
        result.code = 200;
        result.message = "fetch success";
        result.data = menuRoleService.getRoleMenuIds(role_id);
        return result;
    }

    @PostMapping("/addmenu1")
    public BaseModel addMenu1(@RequestBody Menu menu){
        menu.setParent_id(0);
        if(menuRoleService.insertMenu(menu)==1){
            BaseModel result = new BaseModel();
            result.message = "add success";
            result.code = 200;
            return result;
        }else{
            throw new BusinessException().INSERT_FAIL;
        }
    }

    @PostMapping("/addmenu2")
    public BaseModel addMenu2(@RequestBody Menu menu){
        if(menuRoleService.insertMenu(menu)==1){
            BaseModel result = new BaseModel();
            result.message = "add success";
            result.code = 200;
            return result;
        }else{
            throw new BusinessException().INSERT_FAIL;
        }
    }

    @PostMapping("/updatemenu")
    public BaseModel updateMenu(@RequestBody Menu menu){
        if(menuRoleService.updateMenu(menu)==1){
            BaseModel result = new BaseModel();
            result.code = 200;
            result.message = "update success";
            return result;
        }else{
            throw new BusinessException().UPDATE_FAIL;
        }
    }

    @PostMapping("/deletemenu")
    public BaseModel deleteMenu(@RequestParam  int menu_id) {
        if(menuRoleService.deleteMenu(menu_id)==1){
            BaseModel result = new BaseModel();
            result.message = "delete success";
            result.code = 200;
            return result;
        }else{
            throw new BusinessException().DELETE_FAIL;
        }
    }

    @RequiresPermissions("role:rolelist")
    @GetMapping("/rolelist")
    public RoleListJson getRoleList() {
        RoleListJson result = new RoleListJson();
        result.code = 200;
        result.message = "fetch success";
        result.data = menuRoleService.getAllRoles();
        return result;
    }


    @PostMapping("/addrole")
    public BaseModel addRole(@RequestBody Role role){
        if(menuRoleService.insertRole(role)==1){
            BaseModel result = new BaseModel();
            result.message = "add success";
            result.code = 200;
            return result;
        }else{
            throw new BusinessException().INSERT_FAIL;
        }
    }

    @PostMapping("/updaterole")
    public BaseModel updateRole(@RequestBody Role role){
        if(menuRoleService.updateRole(role)==1){
            BaseModel result = new BaseModel();
            result.code = 200;
            result.message = "update success";
            return result;
        }else{
            throw new BusinessException().UPDATE_FAIL;
        }
    }

    @PostMapping("/deleterole")
    public BaseModel deleteRole(@RequestParam  int role_id) {
        if(menuRoleService.deleteRole(role_id)==1){
            BaseModel result = new BaseModel();
            result.message = "delete success";
            result.code = 200;
            return result;
        }else{
            throw new BusinessException().DELETE_FAIL;
        }
    }

    @PostMapping("/setrolemenu")
    public BaseModel setRoleMenu(@RequestParam int role_id, @RequestParam String menu_ids){
        String[] menu_ids_str = menu_ids.split(",");
        int[] menu_ids_int = Arrays.asList(menu_ids_str).stream().mapToInt(Integer::parseInt).toArray();
        Map rolemenu = new HashMap<String,Object>();
        rolemenu.put("role",role_id);
        rolemenu.put("menu",menu_ids_int);
        menuRoleService.deletRoleMenu(role_id);
        int res = menuRoleService.setRoleMenu(rolemenu);
        System.out.println(res);
        if(res==1){
            BaseModel result = new BaseModel();
            result.message = "set success";
            result.code = 200;
            return result;
        }else{
            throw new BusinessException().UPDATE_FAIL;
        }
    }



}
