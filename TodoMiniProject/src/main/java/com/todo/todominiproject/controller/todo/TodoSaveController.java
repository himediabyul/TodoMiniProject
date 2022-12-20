package com.todo.todominiproject.controller.todo;

import com.todo.todominiproject.domain.TodoSaveRequest;
import com.todo.todominiproject.service.todo.TodoSaveService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@Log4j2
@RequestMapping("/todo/save")
public class TodoSaveController {

    @Autowired
    private TodoSaveService saveService;

    @GetMapping
    public void getSaveForm(){

    }
    @PostMapping
    public String saveTodo(TodoSaveRequest saveRequest){

        String absolutePath = new File("").getAbsolutePath();
        log.info("path : " + absolutePath);

        saveService.save(saveRequest);

        log.info("인서트" + saveService.save(saveRequest) );

        return "redirect:/todo/list";
    }
}
