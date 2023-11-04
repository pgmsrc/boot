package com.example.boot.service;

import com.example.boot.entity.Study_record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyRecordServiceTest {

    @Autowired
    StudyRecordService studyRecordService;

    @Test
    void doSelectAll() {
    }

    @Test
    void doSelectOne() {
    }

    @Test
    void doInsert() {
        Study_record study_record = Study_record.builder()
                .study_day("2023.11.05")
                .contents("Insert Test")
                .reg_day(LocalDateTime.now())
                .build();
        studyRecordService.doInsert(study_record);
    }

    @Test
    void doUpdate() {
        /*
        Study_record study_record = new Study_record();
        study_record.setKey_id(3);
        study_record.setContents("Update Test");
        studyRecordService.doUpdate(study_record);
        */

        Study_record study_record = studyRecordService.doSelectOne(1);
        study_record.setContents("Update Test");
        studyRecordService.doUpdate(study_record);
    }

    @Test
    //@Transactional
    void doDelete() {
        studyRecordService.doDelete(3);
    }
}