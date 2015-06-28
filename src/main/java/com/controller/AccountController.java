package com.controller;

import com.entities.po.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by celine on 2015/6/28.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User rstUser =userService.findUserByNameAndPassword(user);
        if(rstUser!=null){
            httpSession.setAttribute("user",user);
            modelAndView.setViewName("/account/success");
            modelAndView.addObject(rstUser);

        }else{
            modelAndView.setViewName("/account/false");
        }
        return modelAndView;
    }
}
