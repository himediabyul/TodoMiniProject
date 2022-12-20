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
    private MultipartFile photo;

    public Todo toTodoEntity(){
        return Todo.builder()
                .todo(todo)
                .writer(writer)
//                .writer(TodoMember.builder().idx(writer).build())
                .build();
    }
}
