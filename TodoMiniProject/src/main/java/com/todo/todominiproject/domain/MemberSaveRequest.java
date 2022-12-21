package com.todo.todominiproject.domain;

import com.todo.todominiproject.entity.Member;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberSaveRequest {

    private String id;

    private String pw;

    private String name;

    private MultipartFile photo;

    private String role;


    public Member toMemberEntity(){
        return Member.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .role(role)
                .build();
    }
}
