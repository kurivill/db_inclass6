import dao.LibraryDAO;
import entity.Author;
import entity.Biography;
import entity.Book;
import entity.Student;

public class main {

    public static void main(String[] args) {


        LibraryDAO dao = new LibraryDAO();

        Author author1 = new Author("J.K. Rowling");
        Biography biography = new Biography("British author, best known for the Harry Potter series.", author1);

        Book book1 = new Book.printedBook("Harry Potter and the Philosopher's Stone", author1, 223);

        dao.addBook(book1);
        dao.addBiography(biography);

        Student student = new Student("Jaska Jokunen");
        dao.addStudent(student);

        dao.borrowBook(student, book1);

    }
}
