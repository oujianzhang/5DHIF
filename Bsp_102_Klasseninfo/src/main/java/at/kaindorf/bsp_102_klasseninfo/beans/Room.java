package at.kaindorf.bsp_102_klasseninfo.beans;


import at.kaindorf.bsp_102_klasseninfo.bl.Floor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Room.findByClassName", query = "SELECT r FROM Room r WHERE r.classname.name = :classname"),
        @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
        @NamedQuery(name = "Room.findByFloor", query = "SELECT r FROM Room r WHERE r.classname.room.floor = :floorname"),
        @NamedQuery(name = "Room.countAll", query = "SELECT COUNT(r) FROM Room r")
})
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long roomId;

    @NonNull
    private String name;
    @NonNull
    @Enumerated(value = EnumType.STRING)
    private Floor floor;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "classname")
    private Classname classname;

}
