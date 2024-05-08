package Model;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "CPU")
    private String CPU;

    @Column(name = "GPU")
    private String GPU;

    @Column(name = "MotherBoard")
    private String MotherBoard;

    @Column(name = "Cooler")
    private String Cooler;

    @Column(name = "RAM")
    private String RAM;

    @Column(name = "CountRam")
    private int CountRAM;

    @Column(name = "SSD")
    private String SSD;

    @Column(name = "Count SSD")
    private int CountSSD;

    @Column(name = "HDD")
    private String HDD;

    @Column(name = "CountHDD")
    private int CountHDD;

    @Column(name = "ComputerCase")
    private String ComputerCase;

    @Column(name = "PowerUnit")
    private String PowerUnit;

    @Column(name = "TotalCost")
    private int TotalCost;

}
