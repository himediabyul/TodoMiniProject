package com.todo.todominiproject.service.todo;

import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoReadService {

    @Autowired
    private TodoRepository todoRepository;


    public Todo readTodo(int tno) {

        return todoRepository.findById(tno).get();
    }



}
