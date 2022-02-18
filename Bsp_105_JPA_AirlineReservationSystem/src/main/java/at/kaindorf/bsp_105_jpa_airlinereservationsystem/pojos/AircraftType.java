package at.kaindorf.bsp_105_jpa_airlinereservationsystem.pojos;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity(name = "Aircraft_Type")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AircraftType implements Serializable {
    @Id
    @Column(name = "aircraft_type_id", nullable = false)
    @GeneratedValue
    @NonNull
    private Long aircraftTypeId;

    @Column(name = "type_name")
    @NonNull
    private String typeName;

    @NonNull
    private int seats;

}
