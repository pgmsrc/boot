package com.example.boot.controller;

import com.example.boot.entity.Study_record;
import com.example.boot.service.StudyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/study")
public class StudyController {

    @Autowired
    StudyRecordService studyRecordService;

    // List 조회
    @GetMapping("/list")
    public String doStudyList(Model model) {
        /* 방법 1
        List<Study_record> list = studyRecordService.doSelectAll();
        model.addAttribute("list", list);
        */
        // 방법 2
        model.addAttribute("list", studyRecordService.doSelectAll());
        return "/study/study_list";
    }

    // 입력
    @GetMapping("/insert")
    public String doInsert() {
        return "/study/study_insert";
    }

    // 등록하기 실행
    @PostMapping("/insert_exe")
    public String doInsertExe(@ModelAttribute Study_record study_record) {
        //study_record.setReg_day(LocalDateTime.now());
        //study_record.setMod_day(LocalDateTime.now());
        studyRecordService.doInsert(study_record);
        return "redirect:/study/list";
    }

    // 수정
    @GetMapping("/modify")
    public String doModify(@RequestParam Integer key_id, Model model) {
        //System.out.println("key_id1: " + key_id);
        model.addAttribute("study", studyRecordService.doSelectOne(key_id));
        model.addAttribute("key_id", key_id);
        return "/study/study_modify";
    }

    // 수정 실행
    @PostMapping("/modify_exe/{key_id}")
    public String doModifyExe(@PathVariable("key_id") Integer key_id, Study_record study_record) {
        //System.out.println("key_id2: " + key_id);
        Study_record studyRecordTemp = studyRecordService.doSelectOne(key_id);
        studyRecordTemp.setStudy_day(study_record.getStudy_day());
        studyRecordTemp.setContents(study_record.getContents());
        //study_record.setMod_day(LocalDateTime.now());
        studyRecordService.doUpdate(studyRecordTemp);
        return "redirect:/study/list";
    }

    // 삭제
    @GetMapping("/delete")
    public String doDelete(@RequestParam Integer key_id) {
        //System.out.println("key_id: " + key_id);
        studyRecordService.doDelete(key_id);
        return "redirect:/study/list";
    }

}
