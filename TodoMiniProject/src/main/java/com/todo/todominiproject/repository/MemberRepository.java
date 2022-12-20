package com.todo.todominiproject.repository;

import com.todo.todominiproject.entity.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("select m from Member m")
    List<Member> findAll();

    @Query("select m from Member m where m.id = :id and m.pw = :pw")
    Member findById(@Param("id") String id, @Param("pw") String pw);

}
