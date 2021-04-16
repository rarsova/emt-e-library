package mk.ukim.finki.emt.library.model;

import lombok.Data;
import mk.ukim.finki.emt.library.model.enumerations.Category;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    @Enumerated(EnumType.STRING)
    public Category category;

    @ManyToOne
    public Author authors;

    public Integer availableCopies;

    public Book() {
    }

    public Book(String name, Category category, Author authors, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authors = authors;
        this.availableCopies = availableCopies;
    }


}
