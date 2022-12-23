package com.todo.todominiproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "mini_todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer tno;

    @Column
    @NotEmpty
    private String todo;

    @Column(updatable = false)
    private String writer;

    @Column
    @NotEmpty
    private String duedate;

    @Column
    private String photo;

    @Column
    @NotEmpty
    private Boolean finished;

}
