/**
 * 
 */
package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.dto.entity.UserEntity;
import com.xpanxion.skeleton.service.UserService;

/**
 * @author brian
 * 
 */
@Controller
@SessionAttributes
public class HomeController {

    private UserService userService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ModelAttribute("user")
    public UserEntity createUser() {
        return new UserEntity();
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        return new ModelAndView("home", "command", new UserEntity());
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("user") UserEntity user, HttpServletRequest req, Model m) {
        UserBean ent = this.userService.verifyUserCredentials(user);
        if (ent != null) {
            req.getSession(true).setAttribute("user", ent.getUsername());
            return "welcome";
        } else {
            m.addAttribute("message", "Username and/or password is incorrect. Please re-enter credentials and try again.");
            return "home";
        }
    }

}
