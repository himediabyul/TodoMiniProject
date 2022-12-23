package com.todo.todominiproject.repository;


import com.todo.todominiproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {




    @Query("select m from Member m")
    List<Member> findAll();

    Optional<Member> findById(String id);

    @Transactional
    @Modifying
    @Query("delete from Member m where m.idx = :idx")
    int deleteByIdx(@Param("idx") Integer idx);


    boolean existsById(String id);


}
