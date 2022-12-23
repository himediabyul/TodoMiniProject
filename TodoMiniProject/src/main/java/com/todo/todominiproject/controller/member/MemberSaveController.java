package com.todo.todominiproject.controller.member;

import com.todo.todominiproject.domain.member.MemberSaveRequest;
import com.todo.todominiproject.service.member.MemberSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("/member/save")
public class MemberSaveController {

    @Autowired
    private MemberSaveService saveService;

    @GetMapping
    public void getSaveForm(){

    }

    @PostMapping
    public String saveMember(@Valid MemberSaveRequest saveRequest, Errors errors, Model model){

        saveService.checkIdDuplication(saveRequest);

        if(errors.hasErrors()) {
            model.addAttribute("user", saveRequest);

            Map<String, String> validateResult = saveService.validateHandling(errors);
            for(String key : validateResult.keySet()){
                model.addAttribute(key, validateResult.get(key));
            }
            return "/member/save";
        }

        saveService.save(saveRequest);
        return "redirect:/";
    }


}
