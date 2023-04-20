package pl.coderslab.entity;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Transactional
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;


    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "content")
    private String content;

    @OneToOne
    @JoinColumn(name = "author_id", unique = true)
    private Author author;

    @OneToMany
    @JoinColumn(name = "article_id")
    private Set<Category> categories = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }


}
