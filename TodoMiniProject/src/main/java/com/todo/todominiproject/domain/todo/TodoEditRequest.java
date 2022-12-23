package com.todo.todominiproject.domain.todo;

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

    private Integer tno;
    private String todo;

    private String writer;
    private String duedate;
    private String oldFile;

    private MultipartFile newPhoto;

    private boolean finished;


    public Todo toTodoEntity(){
        return Todo.builder()
                .tno(tno)
                .todo(todo)
                .writer(writer)
                .duedate(duedate)
                .photo(oldFile)
                .finished(isFinished())
                .build();
    }
}
