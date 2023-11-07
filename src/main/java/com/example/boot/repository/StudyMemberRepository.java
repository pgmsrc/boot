package com.example.boot.repository;

import com.example.boot.entity.Study_member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyMemberRepository extends JpaRepository<Study_member, Integer> {
}
