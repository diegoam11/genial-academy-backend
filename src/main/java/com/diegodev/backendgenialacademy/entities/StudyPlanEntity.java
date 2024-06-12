package com.diegodev.backendgenialacademy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "study_plan")
public class StudyPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_plan_id")
    private Long studyPlanId;
    @Column
    private String name;
    @Column(name = "valid_until")
    private Date validUntil;
    @OneToMany(mappedBy = "studyPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseEntity> courses;
    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private UniversityEntity university;
}
