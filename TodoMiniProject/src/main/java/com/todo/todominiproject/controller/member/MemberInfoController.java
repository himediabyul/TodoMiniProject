package com.todo.todominiproject.controller.member;

import com.todo.todominiproject.service.member.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberInfoController {

        @Autowired
        private MemberInfoService infoService;


        @GetMapping("/member/info")
        public void infoMember(@RequestParam("idx") int idx, Model model) {

            model.addAttribute("info", infoService.memberInfo(idx));

    }

}
