package com.todo.todominiproject.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "mini_member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idx;

    @Column(updatable = false)
    @NotEmpty
    private String id;

    @Column
    @NotEmpty
    private String pw;

    @Column
    @NotEmpty
    private String name;

    @Column
    private String photo;

    @Column(updatable = false)
    private String role;

}
