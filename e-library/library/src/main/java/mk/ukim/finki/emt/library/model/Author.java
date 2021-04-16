package mk.ukim.finki.emt.library.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String surname;

    @ManyToOne
    public Country country;

    public Author() {
    }

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

}
