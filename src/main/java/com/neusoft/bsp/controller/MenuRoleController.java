package com.neusoft.bsp.controller;


import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.System.service.MenuRoleService;
import com.neusoft.bsp.System.vo.MenuListJson;
import com.neusoft.bsp.common.base.BaseModelJsonPaging;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/menurole")
public class MenuRoleController {

    @Autowired
    MenuRoleService menuRoleService;

    @RequiresPermissions("menu:menulist")
    @GetMapping("/menulist")
    public MenuListJson getMenuList(@RequestParam Map<String,Object> map) {
        MenuListJson result = new MenuListJson();
        result.code = 200;
        result.data = menuRoleService.getAllMenus();
        return result;
    }

}
