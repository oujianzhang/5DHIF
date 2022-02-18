package at.kaindorf.bsp_102_klasseninfo.beans;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Classname.findByClassName", query = "SELECT c FROM Classname c WHERE c.name = :classname"),
        @NamedQuery(name = "Classname.findAll", query = "SELECT c FROM Classname c"),
        @NamedQuery(name = "Classname.findByFloor", query = "SELECT c FROM Classname c WHERE c.room.floor = :floorname"),
        @NamedQuery(name = "Classname.countAll", query = "SELECT COUNT(c) FROM Classname c")
})
public class Classname implements Serializable {

    @Id
    @GeneratedValue
    private Long classId;

    @NonNull
    private String name;

    @NonNull
    private int grade;

    @NonNull
    private int size;

    @OneToOne
    @JoinColumn(name = "classteacher")
    private ClassTeacher classTeacher;

    @OneToOne(mappedBy = "classname", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Room room;
}