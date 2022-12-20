package com.todo.todominiproject.controller.member;

import com.todo.todominiproject.service.member.MemberLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberLoginController {

    @Autowired
    private MemberLoginService memberLoginService;


    @GetMapping("/member/list")
    public void login(String id, String pw) {

        memberLoginService.loginMember(id, pw);
    }

}
