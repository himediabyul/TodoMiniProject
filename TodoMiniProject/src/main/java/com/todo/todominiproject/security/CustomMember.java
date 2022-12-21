package com.todo.todominiproject.security;

import com.todo.todominiproject.entity.Member;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomMember extends User {

    private Member member;  // 부가정보를 받아옴


    public CustomMember(String name,  // 이름으로 일치하는지 비교
                        String pw,
                        Collection<? extends GrantedAuthority> authorities,
                        Member member
    ) {
        super(name, pw, authorities);
        this.member = member;
    }

    public CustomMember(String name, String pw, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Member member) {
        super(name, pw, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.member = member;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "boardMember=" + member +
                '}';
    }

}
