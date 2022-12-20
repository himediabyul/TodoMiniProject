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
public class TodoEditRequest {

    private String todo;

    private String duedate;

    private String oldFile;

    private MultipartFile photo;

    private boolean finised;


    public Todo toTodoEntity(){
        return Todo.builder()
                .todo(todo)
                .duedate(duedate)
                .photo(oldFile)
                .finished(isFinised())
                .build();
    }
}
