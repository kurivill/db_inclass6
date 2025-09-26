package entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalDate borrowDate = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    public BorrowedBook() {}

    public BorrowedBook(Book book, Student student) {
        this.book = book;
        this.student = student;
    }
}
