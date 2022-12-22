package com.todo.todominiproject.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoArticleDTO {

    private Integer tno;
    private String todo;
    private String writer;
    private String duedate;
    private String photo;
    private Boolean finished;

}
