package pl.coderslab.entity;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@Entity
@Transactional
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
