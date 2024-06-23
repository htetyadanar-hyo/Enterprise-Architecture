package domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AttendanceRecord {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "ScanDateTime")
    private LocalDateTime scanDateTime;

    @ManyToOne
    @JoinColumn(name = "StudentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "LocationId")
    private Location location;

    // Getters and Setters
}
