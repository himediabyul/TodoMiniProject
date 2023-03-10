package com.todo.todominiproject;

import com.todo.todominiproject.entity.Member;
import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void saveMemberTest(){

        Member member = Member.builder()
                .id("hot")
                .pw(encoder.encode("1234"))
                .name("HOT")
                .role("USER")
                .build();

        Member result = memberRepository.save(member);
        log.info("회원 저장 >>> " + result);
    }


    @Test
    public void findIdTest(){

        Optional<Member> result = memberRepository.findByIdx(9);

        Member member = result.get();

        log.info("9번 회원  >>>>> " + member);

    }

    @Test
    public void deleteTest() {

        int result = memberRepository.deleteByIdx(1);

        log.info("삭제완료 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + result);


    }



}
