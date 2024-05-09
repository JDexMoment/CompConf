package Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CPU")
@Table(name = "CPU")
public class CPU {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPU_seq_gen")
    @SequenceGenerator(name = "CPU_seq_gen", sequenceName = "CPU_seq", allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Cost")
    private int Cost;

    @Column(name = "Description")
    private String Description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "computer_id")
    private Computer computer;
}
