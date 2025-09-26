package entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(
        name = "borrowedbook",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<BorrowedBook> books = new HashSet<>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Student() {}
    public Student(String name) {
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

    public Set<BorrowedBook> getBorrowedBooks() {
        return books;
    }

    public void setBooks(Set<BorrowedBook> books) {
        this.books = books;
    }
}
