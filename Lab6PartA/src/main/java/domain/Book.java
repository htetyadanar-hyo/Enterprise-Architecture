package domain;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Book extends Product{
    private String isbn;

    protected Book(){}

    public Book(String name, String description,double price,String isbn){
        super(name, description, price);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn='" + isbn + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }

}
