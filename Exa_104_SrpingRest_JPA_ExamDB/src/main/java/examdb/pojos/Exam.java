package examdb.pojos;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "exam")
@Entity
@Data
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id", nullable = false)
    private Long examId;

    @Column(name = "dateofexam")
    private LocalDate dateofexam;

    @Column(name = "duration")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject")
    private Subject subject;

}