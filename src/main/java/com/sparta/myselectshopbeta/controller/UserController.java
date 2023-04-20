package com.sparta.myselectshopbeta.controller;

import com.sparta.myselectshopbeta.dto.LoginRequestDto;
import com.sparta.myselectshopbeta.dto.SignupRequestDto;
import com.sparta.myselectshopbeta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller//html만 반환하니 Controller 처리
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public ModelAndView signupPage() {
        return new ModelAndView("signup");
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/signup")
    public String signup(SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return "redirect:/api/user/login";
    }

    @ResponseBody
    @PostMapping("/login") //이전에는 프런트에서 form 태그에서 데이터가 넘어왔는데 이젠 ajax로 바뀌어서 ResponseBody 붙여줘야함
    public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return "success";
    }

}


