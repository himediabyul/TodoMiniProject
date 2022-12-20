package com.todo.todominiproject.controller.todo;

import com.todo.todominiproject.domain.TodoEditRequest;
import com.todo.todominiproject.service.todo.TodoEditService;
import com.todo.todominiproject.service.todo.TodoReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo/edit")
public class TodoEditController {

    @Autowired
    private TodoReadService readService;
    @Autowired
    private TodoEditService editService;

    @GetMapping
    public void getEditForm(@RequestParam("tno") int tno, Model model){

        model.addAttribute("todo", readService.readTodo(tno));

    }

    @PostMapping
    public String editTodo(TodoEditRequest editRequest, RedirectAttributes redirectAttributes){


        redirectAttributes.addAttribute("tno", editRequest.getTno());
        editService.edit(editRequest);

        return "redirect:/todo/read";
    }

}
