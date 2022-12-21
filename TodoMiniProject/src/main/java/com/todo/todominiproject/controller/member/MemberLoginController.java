package com.todo.todominiproject.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {

    @GetMapping
    public void login() {

    }

    @PostMapping
    public String afterLogin() {

        return "redirect:/todo/list";
    }

}
