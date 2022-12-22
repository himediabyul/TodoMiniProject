package com.todo.todominiproject.controller.member;

import com.todo.todominiproject.domain.MemberEditRequest;
import com.todo.todominiproject.service.member.MemberEditService;
import com.todo.todominiproject.service.member.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member/edit")
public class MemberEditController {

    @Autowired
    private MemberInfoService infoService;

    @Autowired
    private MemberEditService editService;

    @GetMapping
    public void getEditForm(@RequestParam("idx") int idx, Model model){

        model.addAttribute("member", infoService.memberInfo(idx));
    }

    @PostMapping
    public String editMember(MemberEditRequest editRequest, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("idx", editRequest.getIdx());
        editService.editMem(editRequest);

        return "redirect:/";
    }

}
