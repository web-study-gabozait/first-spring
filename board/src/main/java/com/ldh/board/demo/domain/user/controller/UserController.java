package com.ldh.board.demo.domain.user.controller;

import com.ldh.board.demo.domain.user.domain.User;
import com.ldh.board.demo.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {return "user/login";}

    @PostMapping("/login")
    public void login(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "password") String password
    ) {
        User user = new User(userId, password, "");
        userService.postLogin(user);
    }


    @GetMapping("/register")
    public  String registerPage() {
        return "user/register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam(value ="userId") String userId,
            @RequestParam(value ="password") String password,
            @RequestParam(value ="name") String name
    ) {
        User user = new User(userId, password, name);
        userService.postSignup(user);

        return "redirect:/user/login";
    }

}
