package at.kaindorf.bsp_105_jpa_airlinereservationsystem.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@IdClass(AirlineId.class)
@RequiredArgsConstructor
public class Airline implements Serializable {
    @Id
    @Column(name = "airline_id", nullable = false)
    @NonNull
    private Long airlineId;

    @Id
    @Column(name = "airline_name", nullable = false)
    @NonNull
    private String airlineName;

    @OneToMany(mappedBy = "airline")
    private List<Aircraft> aircrafts = new ArrayList<>();

}
