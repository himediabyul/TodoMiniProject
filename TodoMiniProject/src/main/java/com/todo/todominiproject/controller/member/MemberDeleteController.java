package com.todo.todominiproject.controller.member;

import com.todo.todominiproject.service.member.MemberDeleteService;
import com.todo.todominiproject.service.todo.TodoDeleteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberDeleteController {

    @Autowired
    private MemberDeleteService memberDeleteService;

    @GetMapping("/member/delete")
    public String deletemember(@Param("idx") int idx) {

        memberDeleteService.deletemember(idx);

        return "redirect:/login";
    }

}
