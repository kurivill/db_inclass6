package dao;

import entity.*;

import jakarta.persistence.*;
import util.creds_provider;

public class LibraryDAO {

    public void addBook(Book book) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            System.out.println("Book added successfully");
        } finally {
            em.close();
        }
    }

    public Book getBook(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            return em.find(Book.class, id);
        } finally {
            em.close();
        }
    }

    public void updateBook(Book book) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
            System.out.println("Book updated successfully");
        } finally {
            em.close();
        }
    }

    public void deleteBook(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            Book book = em.find(Book.class, id);
            if (book != null) {
                em.remove(book);
                System.out.println("Book deleted successfully");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void addAuthor(Author author) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
            System.out.println("Author added successfully");
        } finally {
            em.close();
        }
    }

    public Author getAuthor(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            return em.find(Author.class, id);
        } finally {
            em.close();
        }
    }

    public void updateAuthor(Author author) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(author);
            em.getTransaction().commit();
            System.out.println("Author updated successfully");
        } finally {
            em.close();
        }
    }

    public void deleteAuthor(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            Author author = em.find(Author.class, id);
            if (author != null) {
                em.remove(author);
                System.out.println("Author deleted successfully");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void addStudent(Student student) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            System.out.println("Student added successfully");
        } finally {
            em.close();
        }
    }

    public Student getStudent(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
        }
    }

    public void updateStudent(Student student) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
            System.out.println("Student updated successfully");
        } finally {
            em.close();
        }
    }

    public void deleteStudent(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
                System.out.println("Student deleted successfully");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void addBiography(Biography biography) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(biography);
            em.getTransaction().commit();
            System.out.println("Biography added successfully");
        } finally {
            em.close();
        }
    }

    public Biography getBiography(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            return em.find(Biography.class, id);
        } finally {
            em.close();
        }
    }

    public void updateBiography(Biography biography) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(biography);
            em.getTransaction().commit();
            System.out.println("Biography updated successfully");
        } finally {
            em.close();
        }
    }

    public void deleteBiography(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            Biography biography = em.find(Biography.class, id);
            if (biography != null) {
                em.remove(biography);
                System.out.println("Biography deleted successfully");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void borrowBook(Student student, Book book) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            BorrowedBook borrowedBook = new BorrowedBook(book, student);
            em.persist(borrowedBook);
            student.getBorrowedBooks().add(borrowedBook);

            em.persist(student);
            em.persist(book);
            em.getTransaction().commit();
            System.out.println("Book borrowed successfully");
        } finally {
            em.close();
        }
    }




}
