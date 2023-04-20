package pl.coderslab.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@Entity
@Transactional
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


}
