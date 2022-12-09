package com.himan.signin.controller;

import com.himan.model.repository.UserRepository;
import com.himan.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登录
 * 如果只是一般的安全级别，在前端使用对称加密，后端解密，hash值与数据库比较
 * 如果是安全级别非常高的系统，在前后端交互时，使用非对称加密
 */
@RestController
@RequestMapping(value = "/sign-in")
// 为此类生成提供一个命名为'log'的slf4j成员变量
@Slf4j
public class SignInController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user) {
        // 根据条件查询用户信息，并比对基本信息
        User u = userRepository.findByUserName(user.getUserName());
        if (u == null) {
            log.info("用户不存在：{}", user.getUserName());
            return "用户名不存在";
        } else {
            // 验证用户信息，比对名称、密码、验证码等信息
            boolean valid = BCrypt.checkpw(user.getPassword(), u.getPassword());
            if (!valid) {
                return "用户名或密码错误";
            } else {
                // hash算法 spring security bcrypt
                String hashCode = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
                log.debug("password hashCode:{}", hashCode);
                // 保存用户ID与名称、密码hash
                userRepository.update(hashCode, u.getUserName());
                // TODO 生成token,后续请求都带上token信息
                return "SUCCESS";
            }
        }
    }


    // 发送验证码，将验证码存储在redis

    // 验证码登录,处理同一个用户反复登录问题，网络攻击等
}
