package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {

    @Id
    @GeneratedValue
    private int id;
    String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="p_id")
    private List<Flight> flightList = new ArrayList<>();

    protected Passenger(){}

    public Passenger(String name){
        this.name = name;
    }

    public void addFlight(Flight flight){
        flightList.add(flight);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flightList=" + flightList +
                '}';
    }
}
