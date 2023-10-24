package net.proselyte.springbootdemo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "users" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


}
