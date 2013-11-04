/**
 * 
 */
package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xpanxion.skeleton.dto.entity.UserEntity;
import com.xpanxion.skeleton.service.UserService;

/**
 * @author brian
 * 
 */
@Controller
public class HomeController {

    private UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String makeLogin(@ModelAttribute UserEntity user, Model m) {
        m.addAttribute("user", new UserEntity());
        return "home";
    }

    @Resource
    public void setUserService(UserService service) {
        this.userService = service;
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute UserEntity user, Model m) {
        m.addAttribute("message", "successfully loggged in");
        return "home";
    }

}
