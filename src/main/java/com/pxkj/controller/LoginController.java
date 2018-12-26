package com.pxkj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login-error")
    public String loginError(Model model){
        model.addAttribute("error", true);
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

}
