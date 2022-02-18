package at.kaindorf.bsp_102_klasseninfo.beans;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "ClassTeacher.findByName", query = "SELECT c FROM ClassTeacher c WHERE c.lastname = :lastname"),
        @NamedQuery(name = "ClassTeacher.findByClassname", query = "SELECT c FROM ClassTeacher c WHERE c.classname.name = :classname"),
        @NamedQuery(name = "ClassTeacher.findByGrade", query = "SELECT c FROM ClassTeacher c WHERE c.classname.grade = :grade"),
        @NamedQuery(name = "ClassTeacher.countAll", query = "SELECT COUNT(c) FROM ClassTeacher c")
    }
)
public class ClassTeacher implements Serializable {
    @Id
    @GeneratedValue
    private Long teacherId;

    @NonNull
    private String initials;

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;

    @NonNull
    private String title;

    @OneToOne(mappedBy = "classTeacher", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Classname classname;

}
