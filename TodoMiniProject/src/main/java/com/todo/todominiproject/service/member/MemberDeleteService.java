package com.todo.todominiproject.service.member;

import com.todo.todominiproject.entity.Member;
import com.todo.todominiproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MemberDeleteService {

    @Autowired
    private MemberRepository memberRepository;


    public int deletemember(int idx) {

       Member member = memberRepository.findById(idx).get();

        int result = memberRepository.deleteByIdx(idx);

        if(result>0 && member.getPhoto()!=null){

            File delFile = new File(new File("").getAbsolutePath(), "photo"+File.separator+member.getPhoto());

        }

        return result;

    }


}
