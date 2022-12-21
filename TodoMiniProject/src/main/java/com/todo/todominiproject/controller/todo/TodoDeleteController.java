package com.todo.todominiproject.controller.todo;

import com.todo.todominiproject.service.TodoDeleteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoDeleteController {

    @Autowired
    private TodoDeleteService todoDeleteService;

    @GetMapping("/todo/delete")
    public String deleteTodo(@Param("tno") int tno) {

        todoDeleteService.deleteTodo(tno);

        return "redirect:/todo/list";
    }

}
