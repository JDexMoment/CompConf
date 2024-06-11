package com.example.CompConf.model;

import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(name = "wish_list_id")
    private WishList wishList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cpu_id")
    private Complect cpu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gpu_id")
    private Complect gpu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mother_board__id")
    private Complect motherBoard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cooler_id")
    private Complect cooler;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ram_id")
    private Complect ram;

    @Column(name = "count_Ram")
    private int countRAM;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ssd_id")
    private Complect ssd;

    @Column(name = "count_SSD")
    private int CountSSD;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hdd_id")
    private Complect hdd;

    @Column(name = "count_HDD")
    private int CountHDD;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "computer_case_id")
    private Complect computerCase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "power_unit_id")
    private Complect powerUnit;

    @Column(name = "total_cost")
    private int totalCost;

}
