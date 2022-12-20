package com.todo.todominiproject;

import com.todo.todominiproject.domain.TodoSaveRequest;
import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void saveTest(){

        TodoSaveRequest saveRequest = TodoSaveRequest.builder()
                .todo("프로젝트 완성")
                .writer("별")
                .build();

        Todo todo = saveRequest.toTodoEntity();

        todoRepository.save(todo);

    }
}
