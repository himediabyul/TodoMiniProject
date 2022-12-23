package com.todo.todominiproject.repository;

import com.todo.todominiproject.entity.Todo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query("select t from Todo t")
    List<Todo> findAll(int index, int count);

    List<Todo> findByDuedateContaining(String keyword);

    List<Todo> findByTodoContaining(String keyword);

    @Transactional
    @Modifying
    @Query("delete from Todo t where t.tno = :tno")
    int deleteByTno(@Param("tno") Integer tno);



}
