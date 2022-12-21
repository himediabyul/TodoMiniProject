package com.todo.todominiproject;

import com.todo.todominiproject.entity.Member;
import com.todo.todominiproject.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

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

}
