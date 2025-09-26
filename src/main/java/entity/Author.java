package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "author", cascade = CascadeType.MERGE)
    private Biography biography;
    @OneToMany(mappedBy = "author", cascade = CascadeType.MERGE)

    private Set<Book> books = new HashSet<>();


    public Author() {}

    public Author(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
