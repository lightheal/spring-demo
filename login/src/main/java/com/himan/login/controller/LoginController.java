package com.himan.login.controller;

import com.himan.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user) {
        logger.info("userName:{}", user.getUserName());
        logger.info("userId:{}", user.getUserId());
        return "";
    }
}
