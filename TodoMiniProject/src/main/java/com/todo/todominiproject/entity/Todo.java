package com.todo.todominiproject.entity;

import lombok.*;

import javax.persistence.*;

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
    private String todo;

    @Column
    private String writer;

    @Column
    private String duedate;

    @Column
    private String photo;

    @Column
    private boolean finished;

}
