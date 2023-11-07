package com.example.boot.service;

import com.example.boot.entity.Study_member;
import com.example.boot.repository.StudyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMemberService {

    @Autowired
    StudyMemberRepository studyMemberRepository;

    /* 전체 Row Select */
    public List<Study_member> doSelectAll(){
        return studyMemberRepository.findAll();
    }

    /* One Row Select */
    public Study_member doSelectOne(int member_id){
        return studyMemberRepository.findById(member_id).get();
    }

    /* Insert */
    public void doInsert(Study_member study_member){
        studyMemberRepository.save(study_member);
    }

    /* Update */
    public void doUpdate(Study_member study_member){
        studyMemberRepository.save(study_member);
    }

    /* Delete */
    public void doDelete(int member_id){
        studyMemberRepository.deleteById(member_id);
    }

}
