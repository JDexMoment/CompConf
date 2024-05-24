package com.example.CompConf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Computer")
@Table(name = "Computer")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Comp_seq_gen")
    @SequenceGenerator(name = "Comp_seq_gen", sequenceName = "Comp_seq", allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Wish_List_Id")
    private WishList wishList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complect_id")
    private Complect complect;

    @Column(name = "CPU")
    private Long CPU;

    @Column(name = "GPU")
    private Long GPU;

    @Column(name = "Mother_Board")
    private Long MotherBoard;

    @Column(name = "Cooler")
    private Long Cooler;

    @Column(name = "RAM")
    private Long RAM;

    @Column(name = "Count_Ram")
    private int CountRAM;

    @Column(name = "SSD")
    private Long SSD;

    @Column(name = "Count_SSD")
    private int CountSSD;

    @Column(name = "HDD")
    private Long HDD;

    @Column(name = "Count_HDD")
    private int CountHDD;

    @Column(name = "Computer_Case")
    private Long ComputerCase;

    @Column(name = "Power_Unit")
    private Long PowerUnit;

    @Column(name = "Total_Cost")
    private int TotalCost;

}
