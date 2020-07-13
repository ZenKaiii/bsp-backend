package com.neusoft.bsp.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.Menu;
import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.System.service.MenuRoleService;
import com.neusoft.bsp.System.vo.MenuJson;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModelJsonPaging;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/menurole")
public class MenuRoleController extends BaseController {

    @Autowired
    MenuRoleService menuRoleService;

    @RequiresPermissions("menu:menulist")
    @GetMapping("/menulist")
    public MenuJson getMenuList(Integer page, Integer limit){
        MenuJson result = new MenuJson();
        result.code = 200;
        result.data = menuRoleService.getAllMenusByFilter(new HashMap<String,Object>());
        return result;
    }


}
