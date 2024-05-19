package Model;

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

    @OneToOne
    @JoinColumn(name = "CPU_id")
    private Complect CPU;

    @OneToOne
    @JoinColumn(name = "GPU_id")
    private Complect GPU;

    @OneToOne
    @JoinColumn(name = "MotherBoard_id")
    private Complect MotherBoard;

    @OneToOne
    @JoinColumn(name = "Cooler_id")
    private Complect Cooler;

    @OneToOne
    @JoinColumn(name = "RAM_id")
    private Complect RAM;

    @Column(name = "Count_Ram")
    private int CountRAM;

    @OneToOne
    @JoinColumn(name = "SSD_id")
    private Complect SSD;

    @Column(name = "Count_SSD")
    private int CountSSD;

    @OneToOne
    @JoinColumn(name = "HDD_id")
    private Complect HDD;

    @Column(name = "Count_HDD")
    private int CountHDD;

    @OneToOne
    @JoinColumn(name = "ComputerCase_id")
    private Complect ComputerCase;

    @OneToOne
    @JoinColumn(name = "PowerUnit_id")
    private Complect PowerUnit;

    @Column(name = "Total_Cost")
    private int TotalCost;

}
