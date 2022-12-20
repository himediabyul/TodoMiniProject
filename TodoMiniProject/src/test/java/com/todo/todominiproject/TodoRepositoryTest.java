package com.todo.todominiproject;

import com.todo.todominiproject.domain.TodoSaveRequest;
import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.TodoRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void saveTest(){

        TodoSaveRequest saveRequest = TodoSaveRequest.builder()
                .todo("으아아아")
                .writer("별")
                .duedate("2022-12-23")
                .finished(false)
                .build();

        Todo todo = saveRequest.toTodoEntity();

        todoRepository.save(todo);

        log.info("테스트>>" + todoRepository.save(todo));

    }
}
