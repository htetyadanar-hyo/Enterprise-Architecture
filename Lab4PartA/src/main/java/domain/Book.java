package domain;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int isbn;
    private String title;
    private String author;

    @ManyToOne
    @JoinTable(name="publishId")
    private Publisher publisher;


    protected Book(){
    }

    public Book(String title,String author,Publisher publisher){
        super();
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
