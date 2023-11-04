package com.example.boot.service;

import com.example.boot.entity.Study_record;
import com.example.boot.repository.StudyRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyRecordService {

    @Autowired
    StudyRecordRepository studyRecordRepository;

    /* 전체 Row Select */
    public List<Study_record> doSelectAll(){
        return studyRecordRepository.findAll();
    }

    /* One Row Select */
    public Study_record doSelectOne(int key_id){
        return studyRecordRepository.findById(key_id).get();
    }

    /* Insert */
    public void doInsert(Study_record study_record){
        studyRecordRepository.save(study_record);
    }

    /* Update */
    public void doUpdate(Study_record study_record){
        studyRecordRepository.save(study_record);
    }

    /* Delete */
    public void doDelete(int key_id){
        studyRecordRepository.deleteById(key_id);
    }

}
