package Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "GPU")
@Table(name = "GPU")
public class GPU {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GPU_seq_gen")
    @SequenceGenerator(name = "GPU_seq_gen", sequenceName = "GPU_seq", allocationSize = 1)

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
