package com.example.CompConf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Complect")
@Table(name = "Complect")
public class Complect {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complect_hen_seq")
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

    @OneToMany(mappedBy = "complect", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Computer> computers;

}
