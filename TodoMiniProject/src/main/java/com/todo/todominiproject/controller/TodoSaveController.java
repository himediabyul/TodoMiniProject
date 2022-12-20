package com.todo.todominiproject.controller;

import com.todo.todominiproject.domain.TodoSaveRequest;
import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.service.TodoSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class TodoSaveController {

    @Autowired
    private TodoSaveService saveService;

    @GetMapping("/todo/save")
    public void getSaveForm(){

    }
    @PostMapping
    public String saveTodo(TodoSaveRequest saveRequest) throws IOException {

        String absolutePath = new File("").getAbsolutePath();

        saveService.save(saveRequest);

        return "redirect:/todo/list";
    }
}
