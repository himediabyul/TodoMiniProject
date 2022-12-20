package com.todo.todominiproject.domain;

import com.todo.todominiproject.entity.Todo;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoSaveRequest {

    private String todo;
    private String writer;
    private String duedate;

    private MultipartFile photo;

    private boolean finished;

    public Todo toTodoEntity(){
        return Todo.builder()
                .todo(todo)
                .writer(writer)
                .duedate(duedate)
//                .writer(TodoMember.builder().idx(writer).build())
                .finished(isFinished())
                .build();
    }
}
