package com.lwp.controller;

import com.lwp.dto.User;
import com.lwp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "/getString",method = RequestMethod.GET)
    @ResponseBody
    public String getString(){
        return "sd!==";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(User user){
        System.out.println(user);
        int i = testService.addUser(user);
        System.out.println(i);
        return "sd";
    }
}
