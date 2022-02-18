package examdb.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "student")
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long id;

    @Column(name = "firstname", length = 80)
    private String firstname;

    @Column(name = "lastname", length = 80)
    private String lastname;

    @ManyToOne(optional = false)
    @JoinColumn(name = "classname", nullable = false)
    private Classname classname;

    @OneToMany
    List<Exam> exams = new ArrayList<>();
}