package com.todo.todominiproject.service;

import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class TodoDeleteService {

    @Autowired
    private TodoRepository todoRepository;


    public int deleteTodo(int tno) {

        Todo todo = todoRepository.findById(tno).get();

        int result = todoRepository.deleteByTno(tno);

        if(result>0 && todo.getPhoto()!=null){

            File delFile = new File(new File("").getAbsolutePath(), "photo"+File.separator+todo.getPhoto());

        }

        return result;

    }

}
