package domain;

import jakarta.persistence.Entity;

@Entity
public class DVD extends Product{
    private String genre;

    protected DVD(){}

    public DVD(String name, String description,double price,String genre){
        super(name, description, price);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "genre='" + genre + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
