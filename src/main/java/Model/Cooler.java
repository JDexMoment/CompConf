package Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Cooler")
@Table(name = "Cooler")
public class Cooler {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cooler_seq_gen")
    @SequenceGenerator(name = "Cooler_seq_gen", sequenceName = "Cooler_seq", allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Cost")
    private int Cost;

    @Column(name = "Description")
    private String Description;
}
