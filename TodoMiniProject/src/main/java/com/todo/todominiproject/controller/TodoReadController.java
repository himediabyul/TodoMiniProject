package com.todo.todominiproject.controller;

import com.todo.todominiproject.service.TodoReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoReadController {

    @Autowired
    private TodoReadService todoReadService;


    @GetMapping("/todo/read")
    public void readTodo(@RequestParam("tno") int tno, Model model) {

        model.addAttribute("read", todoReadService.readTodo(tno));

    }

}