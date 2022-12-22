package com.todo.todominiproject.domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchType {

    private String searchOption;

    private String keyword;
}
