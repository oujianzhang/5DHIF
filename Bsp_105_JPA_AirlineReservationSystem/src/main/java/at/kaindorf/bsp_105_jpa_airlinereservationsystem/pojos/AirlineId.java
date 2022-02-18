package at.kaindorf.bsp_105_jpa_airlinereservationsystem.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AirlineId implements Serializable {
    private String airlineId;
    private String airlineName;
}
