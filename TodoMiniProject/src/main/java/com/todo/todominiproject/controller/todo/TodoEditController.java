package com.todo.todominiproject.controller.todo;

import com.todo.todominiproject.domain.TodoEditRequest;
import com.todo.todominiproject.service.todo.TodoEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo/edit")
public class TodoEditController {

    @Autowired
    private TodoEditService editService;

    @GetMapping
    public void getEditForm(){

    }

    public String editTodo(TodoEditRequest editRequest){

        editService.edit(editRequest);

        return "redirect:/todo/list";
    }

}
