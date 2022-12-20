package com.todo.todominiproject.service;

import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getList(){

        return todoRepository.findAll();
    }
}
