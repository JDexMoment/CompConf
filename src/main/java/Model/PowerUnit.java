package Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PowerUnit")
@Table(name = "PowerUnit")
public class PowerUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Power_seq_gen")
    @SequenceGenerator(name = "Power_seq_gen", sequenceName = "Power_seq", allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Cost")
    private int Cost;

    @Column(name = "Description")
    private String Description;
}
