package com.diegodev.backendgenialacademy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "university")
public class UniversityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long universityId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String acronym;
    @Column(nullable = false)
    private String type;
    @Column
    private String website;
    @JsonIgnore
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudyPlanEntity> studyPlans;
}
