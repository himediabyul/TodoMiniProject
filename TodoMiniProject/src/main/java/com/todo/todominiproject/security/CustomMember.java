package com.todo.todominiproject.security;

import com.todo.todominiproject.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomMember extends User {

    @Autowired
    private Member member;


    public CustomMember(String username,
                        String password,
                        Collection<? extends GrantedAuthority> authorities,
                        Member member
    ) {
        super(username, password, authorities);
        this.member = member;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "boardMember=" + member +
                '}';
    }

}
