package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.dto.entity.UserEntity;
import com.xpanxion.skeleton.service.UserService;

@Controller
public class WelcomeController {

    private UserService userService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "welcome")
    public ModelAndView welcomePageRequest(HttpServletRequest req) {
        UserBean user = this.userService.verifyUsernameExists((String) req.getSession().getAttribute("user"));
        ModelAndView mAndV = new ModelAndView("welcome");
        Days d;

        if (user == null) {
            return new ModelAndView("forward:/home", "command", new UserEntity());
        }

        mAndV.addObject("user", user);
        DateTime lastLogin = user.getLastLogin();

        if (lastLogin != null) {
            d = Days.daysBetween(lastLogin, DateTime.now());
        } else {
            d = Days.ZERO;
        }

        mAndV.addObject("sincelastlogon", d);
        user.setLastLogin(DateTime.now());
        this.userService.setLastLoginTime(user);

        return mAndV;

    }

}
