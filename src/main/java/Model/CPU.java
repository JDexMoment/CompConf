package Model;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

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
}
