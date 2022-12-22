package com.todo.todominiproject.service.admin;

import com.todo.todominiproject.entity.Member;
import com.todo.todominiproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberListService {

    @Autowired
    private MemberRepository memberRepository;


    public List<Member> memberList() {

        return memberRepository.findAll();
    }

}
