package at.kaindorf.springburger.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Burger implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull

    private String name;

    @NonNull
    @ManyToMany
    private List<String> ingredients = new ArrayList<>();

    @OneToMany
    private Order order;

}
