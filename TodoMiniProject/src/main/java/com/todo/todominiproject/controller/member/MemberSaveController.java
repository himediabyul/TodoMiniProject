package com.todo.todominiproject.controller.member;

import com.todo.todominiproject.domain.MemberSaveRequest;
import com.todo.todominiproject.service.member.MemberSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/save")
public class MemberSaveController {

    @Autowired
    private MemberSaveService saveService;

    @GetMapping
    public void getSaveForm(){

    }

    @PostMapping
    public String saveMember(MemberSaveRequest saveRequest){

        saveService.save(saveRequest);

        return "redirect:/";
    }

}
