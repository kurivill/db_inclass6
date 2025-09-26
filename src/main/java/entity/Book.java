package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public Book() {}
    public Book(String title, Author author) {
        this.title = title;
        this.author = author;

    }

    public Long getId() {return id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public Author getAuthor() {return author;}

    public void setAuthor(Author author) {this.author = author;}

    @Entity
    public static class printedBook extends Book {
        private int pagecount;

        public printedBook() {}
        public printedBook(String title, Author author, int pagecount) {
            super(title, author);
            this.pagecount = pagecount;
        }

        public int getPagecount() {return pagecount;}

        public void setPagecount(int pagecount) {this.pagecount = pagecount;}
    }

    @Entity
    public static class eBook extends Book {
        private String downloadUrl;

        public eBook() {}
        public eBook(String title, Author author, String downloadUrl) {
            super(title, author);
            this.downloadUrl = downloadUrl;
        }

        public String getDownloadUrl() {return downloadUrl;}

        public void setDownloadUrl(String downloadUrl) {this.downloadUrl = downloadUrl;}
    }
}

