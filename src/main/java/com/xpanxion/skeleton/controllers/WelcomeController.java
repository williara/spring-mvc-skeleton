package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public ModelAndView welcomePageRequest(HttpServletRequest req) {
        UserBean user = this.userService.returnUserFromUserName((String) req.getAttribute("user"));
        ModelAndView mAndV = new ModelAndView("welcome");
        Days d = Days.FOUR;
        if (user != null) {
            mAndV.addObject("user", user);
            DateTime lastLogin = user.getLastLogin();
            if (lastLogin.equals(null)) {
                d = Days.ZERO;
            } else {
                d = Days.ONE;
            }
            mAndV.addObject("sincelastlogon", d);
            user.setLastLogin(DateTime.now());
            this.userService.setLastLoginFor(user);

            return mAndV;
        } else {
            return new ModelAndView("home", "command", new UserEntity());
        }
    }

}
