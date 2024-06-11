package com.example.CompConf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Complect")
@Table(name = "Complect")
public class Complect {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complect_seq_gen")
    @SequenceGenerator(name = "complect_seq_gen", sequenceName = "complect_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private int cost;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

}
