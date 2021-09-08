package ru.otus.SpringMvcHomework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Author.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_author_id"), nullable = true)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", foreignKey = @ForeignKey(name = "fk_genre_id"))
    private Genre genre;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Comment> comment;
}
