package com.todo.todominiproject.controller.member;

import com.todo.todominiproject.service.member.MemberListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberListController {

    @Autowired
    private MemberListService memberListService;


    @GetMapping("/member/list")
    public void getMemberList(Model model) {

        model.addAttribute("mList", memberListService.getMember());

    }

}
