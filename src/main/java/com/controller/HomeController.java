package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by u6031313 on 6/23/2015.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/index")
    public String index(Model model,HttpSession session){
        Object user  = session.getAttribute("user");
        if (user!=null){
            model.addAttribute(user);
        }
        return "/home/index";
    }
}
