package com.pxkj.controller;

import com.pxkj.entity.SysUser;
import com.pxkj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('UserIndex')")
    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }

    @PreAuthorize("hasAuthority('UserList')")
    @RequestMapping(value = "/list")
    public String list(){
        return "user/list";
    }

    @PreAuthorize("hasAuthority('UserAdd')")
    @RequestMapping(value = "/add")
    public String add(){
        return "user/add";
    }

    @PreAuthorize("hasAuthority('UserDetail')")
    @RequestMapping(value = "/detail")
    public String detail(){
        return "user/detail";
    }

    @RequestMapping(value = "/hi")
    @ResponseBody
    public String hi(){
        SysUser sysUser = userService.getUserByName("zhangsan");
        return sysUser.toString();
    }

}
