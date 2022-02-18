package examdb.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "classname")
@Entity
@Data
public class Classname {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", nullable = false)
    private Long classId;

    @Column(name = "classname", length = 10)
    private String classname;

    @OneToMany
    private List<Student> students = new ArrayList<>();

}