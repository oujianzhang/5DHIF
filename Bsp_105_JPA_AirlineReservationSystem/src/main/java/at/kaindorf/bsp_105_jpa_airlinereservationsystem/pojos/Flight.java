package at.kaindorf.bsp_105_jpa_airlinereservationsystem.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_id") // oooo coding conventions such wow
    private Long flightId;


    private LocalTime departure_time;
    private LocalTime arrival_time;

    @ManyToOne
    private Aircraft aircraft_id;

    @ManyToOne
    private Airline airline_id;

    @ManyToOne
    private Airport departure_airport;

    @ManyToOne
    private Airport arrival_airport;



}
