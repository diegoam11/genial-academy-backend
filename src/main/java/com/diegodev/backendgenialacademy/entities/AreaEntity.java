package com.diegodev.backendgenialacademy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "area")
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(name = "cod_area")
    private String codArea;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityEntity university;
}
