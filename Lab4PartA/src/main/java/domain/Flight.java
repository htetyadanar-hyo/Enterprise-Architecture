package domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private int Id;
    private String flightNumber;

    @Column(name="`from`")
    private String from;
    @Column(name="`to`")
    private String to;
    @Column
    private LocalDate date;

    protected Flight(){}

    public Flight(String flightNumber,String from,String to,LocalDate date){
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "Id=" + Id +
                ", flightNumber='" + flightNumber + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                '}';
    }
}
