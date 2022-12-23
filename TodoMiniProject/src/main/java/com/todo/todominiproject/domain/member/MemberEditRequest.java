package com.todo.todominiproject.domain.member;

import com.todo.todominiproject.entity.Member;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberEditRequest {

    private Integer idx;

    private String id;

    private String pw;

    private String name;

    private String oldPhoto;

    private MultipartFile newPhoto;

    private String role;

    public Member toMemberEntity(){
        return Member.builder()
                .idx(idx)
                .id(id)
                .pw(pw)
                .name(name)
                .photo(oldPhoto)
                .role(role)
                .build();
    }

}
