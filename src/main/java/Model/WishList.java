package Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "WhishList")
@Table(name = "WhishList")
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Whish_seq_gen")
    @SequenceGenerator(name = "Wish_seq_gen", sequenceName = "Wish_seq", allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User UserId;

    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL)
    private Computer ComputerId;
}
