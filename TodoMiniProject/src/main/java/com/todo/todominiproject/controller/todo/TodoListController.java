package com.todo.todominiproject.controller.todo;

import com.todo.todominiproject.domain.todo.SearchType;
import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.service.todo.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoListController {

    @Autowired
    private TodoListService listService;

    @GetMapping("/todo/list")
    public void getTodoList(@RequestParam(value = "p", defaultValue = "1") int pageNum, Model model){

        model.addAttribute("list", listService.getList(pageNum));
        model.addAttribute("listPage", listService.getPage(pageNum));
    }

    @GetMapping("/todo/search")
    public String search(SearchType searchType, Model model) {

        List<Todo> searchList = listService.search(searchType);

        model.addAttribute("searchList", searchList);

        return "/todo/searchList";
    }

}
