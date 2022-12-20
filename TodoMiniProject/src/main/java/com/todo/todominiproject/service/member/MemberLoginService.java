package com.todo.todominiproject.service.member;

import com.todo.todominiproject.entity.Member;
import com.todo.todominiproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginService {

    @Autowired
    private MemberRepository memberRepository;


    public Member loginMember(String id, String pw) {

        return memberRepository.findById(id, pw);
    }

}
