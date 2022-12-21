package com.todo.todominiproject.repository;


import com.todo.todominiproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("select m from Member m")
    List<Member> findAll();

    @Query("select m from Member m where m.id = :id")
    Optional<Member> findByUserid(@Param("id") String id);








}
