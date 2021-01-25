package com.oktenweb.javaadvjune.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movie {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
//    @Column()   optional

    private String title;
    private int duration;
}
