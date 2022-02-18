package at.kaindorf.bsp_105_jpa_airlinereservationsystem.pojos;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@RequiredArgsConstructor
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aircraft_id", nullable = false)
    private Long aircraftId;

    @Column(name = "airline_name")
    @NonNull
    private String name;

    @ManyToOne
    private Airline airline;

    @ManyToOne
    @Column(name = "aircraft_type")
    private AircraftType aircraftType;

    @ManyToMany(mappedBy = "aircraftList")
    private List<Airport> airportList = new ArrayList<>();

}
