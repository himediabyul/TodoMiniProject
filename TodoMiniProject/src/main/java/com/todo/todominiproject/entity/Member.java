package com.todo.todominiproject.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column
    private String id;

    @Column
    private String pw;

    @Column
    private String name;

    @Column
    private String photo;

}
