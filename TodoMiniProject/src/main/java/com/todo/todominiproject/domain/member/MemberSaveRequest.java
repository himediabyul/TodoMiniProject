package com.todo.todominiproject.domain.member;

import com.todo.todominiproject.entity.Member;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberSaveRequest {


    private Integer idx;
    @NotBlank(message = "아이디는 필수 입력 값 입니다.")
    private String id;
    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    private String pw;
    @NotBlank(message = "이름은 필수 입력 값 입니다.")
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
