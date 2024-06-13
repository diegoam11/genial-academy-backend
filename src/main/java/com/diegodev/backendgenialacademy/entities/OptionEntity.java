package com.diegodev.backendgenialacademy.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "quiz_option")
public class OptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long optionId;
    @Column(name = "option_text")
    private String optionText;
    @Column
    private Boolean isCorrect = false;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private QuizEntity quiz;
}
