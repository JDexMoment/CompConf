package Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "WishList")
@Table(name = "WishList")
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Wish_seq_gen")
    @SequenceGenerator(name = "Wish_seq_gen", sequenceName = "Wish_seq", allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "wishList", orphanRemoval = true, fetch = FetchType.EAGER, targetEntity = Computer.class)
    private List<Computer> computers;
}
