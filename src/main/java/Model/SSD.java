package Model;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "SSD")
@Table(name = "SSD")
public class SSD {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SSD_seq_gen")
    @SequenceGenerator(name = "SSD_seq_gen", sequenceName = "SSD_seq", allocationSize = 1)
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
