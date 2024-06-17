package com.diegodev.backendgenialacademy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_detail")
public class UserDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String phone;
    @Column
    private String typeSchool;
    @OneToOne
    @JoinColumn(name = "district_id")
    private DistrictEntity district;
    @OneToOne
    @JoinColumn(name = "career_id")
    private CareerEntity career;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
