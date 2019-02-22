package com.garylee.blog.controller;

import com.garylee.blog.dao.UserDao;
import com.garylee.blog.domain.User;
import com.garylee.blog.service.UserService;
import com.garylee.blog.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

/**
 * Created by GaryLee on 2019-02-21 19:19.
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("logining")
    @ResponseBody
    public Result logining(User userParam, HttpSession session){
        String name = userParam.getName();
        name = HtmlUtils.htmlEscape(name);
        //shiro
        //获取subject对象
        Subject subject = SecurityUtils.getSubject();
        //token传递输入的账号和密码
        UsernamePasswordToken token = new UsernamePasswordToken(name,userParam.getPassword());
        try {
            //登陆操作,没报错的话则登陆成功
            subject.login(token);
            //根据name到数据库获取对应的user
            User user = userDao.findByName(name);
            //没catch到错误说明
            session.setAttribute("user",user);
            return Result.success();
        }catch (AuthenticationException e){
            String message = "账号或密码错误";
            return Result.fail(message);
        }
    }
    @RequestMapping("/register")
    @ResponseBody
    public Result register(User user){
        String name = user.getName();
        String password = user.getPassword();
        //可将name转义,防止有人恶意注册,如 “<script>alert('papapa')</script> ”,导致打开网页就会弹窗
        //转义后则为“&lt;script&gt;alert(&#39;papapa&#39;)&lt;/script&gt;”
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
        if(exist){
            String message = "用户名已经被使用,不能使用";
            return Result.fail(message);
        }

        //shiro
        //盐,随机生成,用于与已有字符串拼接
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //加密次数(即加密后的字符串继续加密)
        int times = 2;
        //加密算法
        String algorithmName = "md5";
        //生成加密码
        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
        user.setSalt(salt);
        user.setPassword(encodedPassword);

        userService.add(user);
        return Result.success();
    }
}
