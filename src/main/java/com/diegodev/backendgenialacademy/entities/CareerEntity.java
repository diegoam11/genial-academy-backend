package com.diegodev.backendgenialacademy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "career")
public class CareerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private Long careerId;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private UniversityEntity university;
}
