package entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="biographies")
public class Biography {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String details;
    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public Biography() {}

    public Biography(String details, Author author) {
        this.details = details;
        this.author = author;
    }



}
