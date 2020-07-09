package com.neusoft.bsp.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.System.service.UserService;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.base.BaseModelJsonPaging;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {
    @Autowired
    UserService userService;

    @PostMapping("/checkUser")
    public BaseModelJson<User> checkUser(@RequestParam String username, @RequestParam String password) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try{
            subject.login(token);
            User user = (User)subject.getPrincipal();
            BaseModelJson<User> result = new BaseModelJson<User>();
            result.code = 200;
            result.data = user;
            return result;

        }catch(IncorrectCredentialsException e){
            throw BusinessException.PASSWORD_WRONG;
        }catch(UnknownAccountException e){
            throw BusinessException.USERNAME_NOT_EXISTS;
        }

//        Map<String,Object> map = new HashMap<>();
//        map.put("username",username);
//        map.put("password",password);
//        List<User> users = userService.getAllByFilter(map);
//        if(users.size()==0){
//            throw BusinessException.USERNAME_NOT_EXISTS;
//        }else{
//            BaseModelJson result = new BaseModelJson<User>();
//            result.code = 200;
//            result.message = users.get(0).toString();
//            return result;
//        }
    }

    @RequiresPermissions("user:userlist")
    @GetMapping("/userlist")
    public BaseModelJsonPaging<PageInfo<User>> getUserList(Integer page, Integer limit,
                                                     String username, String name, String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("name", name);
        map.put("email", email);
        BaseModelJsonPaging<PageInfo<User>> result = new BaseModelJsonPaging<PageInfo<User>>();
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 10;
        }
        result.code = 200;
        result.data = userService.getAllByFilter(page, limit, map);
        result.total = userService.getAllByFilter(page, limit, map).getSize();

        return result;
    }

    @GetMapping("/getInfo")
    public BaseModelJson<Map> getInfoForVue() {
        //System.out.println();
        Map<String, Object> map = new HashMap<>();
        map.put("roles", new String[]{"admin-token"});
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");

        BaseModelJson<Map> result = new BaseModelJson();
        result.code = 200;
        result.data = map;
        return result;
    }

    @GetMapping("/relogin")
    public BaseModelJson<String> relogin() {
        throw BusinessException.RELOGIN;
    }

    @PostMapping("/logout")
    public void logout() {
        BaseModelJson<String> result = new BaseModelJson();
        result.code = 200;
        result.data = "success";
    }

}
