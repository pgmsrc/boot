package com.example.boot.controller;

import com.example.boot.entity.Study_member;
import com.example.boot.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    StudyMemberService studyMemberService;

    @GetMapping("/list")
    public String doStudyList(Model model) {
        // 방법 1
        List<Study_member> list = studyMemberService.doSelectAll();
        model.addAttribute("list", list);

        // 방법 2
        //model.addAttribute("list", studyMemberService.doSelectAll());

        return "/member/member_list";
    }

    // 화원가입
    @GetMapping("/insert")
    public String doInsert() {
        return "/member/member_join";
    }

    // 회원가입 실행
    @PostMapping("/insert_exe")
    public String doInsertExe(@ModelAttribute Study_member study_member) {
        //study_record.setReg_day(LocalDateTime.now());
        //study_record.setMod_day(LocalDateTime.now());
        studyMemberService.doInsert(study_member);
        return "redirect:/member/list";
    }

    // 삭제
    @GetMapping("/delete")
    public String doDelete(@RequestParam Integer member_id) {
        //System.out.println("member_id: " + member_id);
        studyMemberService.doDelete(member_id);
        return "redirect:/member/list";
    }

}
