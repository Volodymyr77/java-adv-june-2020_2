package com.oktenweb.javaadvjune.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movie {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
//    @Column()   optional

//    @Column(name = "movie_title")
    @NotBlank
    private String title;
    @Positive
    @Max(value = 210)
    private int duration;
}
