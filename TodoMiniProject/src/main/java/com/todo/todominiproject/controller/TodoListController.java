package com.todo.todominiproject.controller;

import com.todo.todominiproject.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoListController {

    @Autowired
    private TodoListService listService;

    @GetMapping("/todo/list")
    public void getTodoList(Model model){

        model.addAttribute("list", listService.getList());
    }
}
