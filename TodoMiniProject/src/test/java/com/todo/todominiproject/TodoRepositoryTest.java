package com.todo.todominiproject;

import com.todo.todominiproject.domain.TodoEditRequest;
import com.todo.todominiproject.domain.TodoSaveRequest;
import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.TodoRepository;
import com.todo.todominiproject.service.todo.TodoEditService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

/*    @Test
    public void saveTest(){

        TodoSaveRequest saveRequest = TodoSaveRequest.builder()
                .todo("으아아아")
                .writer("별")
                .duedate("2022-12-23")
                .finished(false)
                .build();

        Todo todo = saveRequest.toTodoEntity();

        Todo insert = todoRepository.save(todo);

        log.info("테스트>>" + insert);

    }*/

    @Test
    public void findIdTest(){

        // view 페이지 , edit form
        Optional<Todo> result = todoRepository.findById(1);

        Todo todo = result.get();

        log.info("1번 게시물  >>>>> " + todo);

    }

    @Test
    public void editTest(){

        TodoEditRequest editRequest = TodoEditRequest.builder()
                .tno(1)
                .todo("수정테스트")
                .duedate("2022-12-31")
                .finised(true)
                .build();

        Todo todo = editRequest.toEditEntity();

        Todo editTodo = todoRepository.save(todo);

        log.info("수정 테스트 >> " + editTodo);
    }
}
