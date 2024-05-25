package com.example.CompConf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonIgnore
    @OneToMany(mappedBy = "cpu", fetch = FetchType.EAGER)
    private List<Computer> cpus;

    @JsonIgnore
    @OneToMany(mappedBy = "gpu", fetch = FetchType.EAGER)
    private List<Computer> gpus;

    @JsonIgnore
    @OneToMany(mappedBy = "motherBoard", fetch = FetchType.EAGER)
    private List<Computer> motherBoards;

    @JsonIgnore
    @OneToMany(mappedBy = "cooler", fetch = FetchType.EAGER)
    private List<Computer> coolers;

    @JsonIgnore
    @OneToMany(mappedBy = "ram", fetch = FetchType.EAGER)
    private List<Computer> rams;

    @JsonIgnore
    @OneToMany(mappedBy = "ssd", fetch = FetchType.EAGER)
    private List<Computer> ssds;

    @JsonIgnore
    @OneToMany(mappedBy = "hdd", fetch = FetchType.EAGER)
    private List<Computer> hdds;

    @JsonIgnore
    @OneToMany(mappedBy = "computerCase", fetch = FetchType.EAGER)
    private List<Computer> computerCases;

    @JsonIgnore
    @OneToMany(mappedBy = "powerUnit", fetch = FetchType.EAGER)
    private List<Computer> powerUnits;
}
