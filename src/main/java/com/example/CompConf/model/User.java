package com.example.CompConf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "App_User")
@Table(name = "App_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_seq_gen")
    @SequenceGenerator(name = "User_seq_gen", sequenceName = "User_seq", allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private WishList wishList;

}
