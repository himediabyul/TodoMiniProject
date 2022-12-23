package com.todo.todominiproject.domain.todo;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchType {

    private String searchOption;  // 검색 옵션

    private String keyword; // 키워드
}
