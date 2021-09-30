package com.example.jpaintro.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Address implements Serializable {

    @Id
    @Column(name="address_id", nullable = false)
    @GeneratedValue
    private long addressId;

    @NonNull
    @Column(length = 127, nullable = false)
    private String city;

    @NonNull
    @Column(length = 127, nullable = false)
    private String street;

    @NonNull
    @Column(length = 127, nullable = false)
    private String number;

    @OneToOne(mappedBy = "address")
    private Student student;

}
