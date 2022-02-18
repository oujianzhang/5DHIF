package examdb.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "subject")
@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", nullable = false)
    private Long id;

    @Column(name = "longname", length = 100)
    private String longname;

    @Column(name = "shortname", length = 10)
    private String shortname;

    @Column(name = "written", nullable = false)
    private Boolean written = false;

    @OneToMany
    List<Exam> exams = new ArrayList<>();
}