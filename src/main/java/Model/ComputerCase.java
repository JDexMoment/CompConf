package Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ComputerCase")
@Table(name = "ComputerCase")
public class ComputerCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CompCase_seq_gen")
    @SequenceGenerator(name = "CompCase_seq_gen", sequenceName = "CompCase_seq", allocationSize = 1)
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
