package at.kaindorf.bsp_105_jpa_airlinereservationsystem.pojos;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@RequiredArgsConstructor
public class Airport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "airport_id", nullable = false)
    @NonNull
    private Long airportId;

    @NonNull
    private String country;
    @NonNull
    private String city;
    @NonNull
    private String name;


    @OneToMany(mappedBy = "arrival_airport", orphanRemoval = true)
    private List<Flight> flights = new ArrayList<>();

    @ManyToMany
    private List<Aircraft> aircraftList = new ArrayList<>();

    public void addAircraft(Aircraft aircraft) {
        if(!aircraftList.contains(aircraft))
            aircraftList.add(aircraft);
    }
}
