package com.diegodev.backendgenialacademy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "province")
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private Long provinceId;
    @Column
    private String name;
    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DistrictEntity> districts;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

}
