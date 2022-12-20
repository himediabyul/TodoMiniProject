package com.todo.todominiproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.todo.todominiproject.mapper")
public class TodoMiniProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoMiniProjectApplication.class, args);
    }

}
