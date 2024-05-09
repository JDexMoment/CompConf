package Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
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

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CPU> CPUId;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GPU> GPUId;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MotherBoard> MotherBoardId;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cooler> CoolerId;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RAM> RAMId;

    @Column(name = "Count_Ram")
    private int CountRAM;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SSD> SSDId;

    @Column(name = "Count_SSD")
    private int CountSSD;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HDD> HDDId;

    @Column(name = "Count_HDD")
    private int CountHDD;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ComputerCase> ComputerCaseId;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PowerUnit> PowerUnitId;

    @Column(name = "Total_Cost")
    private int TotalCost;

}
