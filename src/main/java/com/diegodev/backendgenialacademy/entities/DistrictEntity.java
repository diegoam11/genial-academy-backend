package com.diegodev.backendgenialacademy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "district")
public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disctrict_id")
    private Long disctrictId;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private ProvinceEntity province;
}
