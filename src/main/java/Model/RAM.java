package Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "RAM")
@Table(name = "RAM")
public class RAM {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RAM_seq_gen")
    @SequenceGenerator(name = "RAM_seq_gen", sequenceName = "RAM_seq", allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Cost")
    private int Cost;

    @Column(name = "Description")
    private String Description;
}
