package com.todo.todominiproject.controller.member;

import com.todo.todominiproject.service.member.MemberSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberSaveController {

    @Autowired
    private MemberSaveService saveService;

    

}
