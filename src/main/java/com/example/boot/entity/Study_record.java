package com.example.boot.entity;

import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Study_record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int key_id;

    private String study_day;

    private String contents;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name="reg_day", updatable = false)
    private LocalDateTime reg_day;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name="mod_day")
    private LocalDateTime mod_day;
}