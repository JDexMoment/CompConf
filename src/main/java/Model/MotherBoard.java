package Model;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "MotherBoard")
@Table(name = "MotherBoard")
public class MotherBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Mother_seq_gen")
    @SequenceGenerator(name = "Mother_seq_gen", sequenceName = "Mother_seq", allocationSize = 1)

    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Cost")
    private int Cost;

    @Column(name = "Description")
    private String Description;
}
