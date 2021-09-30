package com.example.jpaintro.pojos;

import lombok.*;
import org.eclipse.persistence.jpa.config.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity(name = "Student")
@IdClass(StudentPK.class)
public class Student implements Serializable {
//    @Id
//    @Column(name = "student_id")
//    @GeneratedValue //(strategy = GenerationType.AUTO) macht sequence
//    private String studentId;
    @NonNull
    @Id
    private long catNo;
    @NonNull
    @Id
    private String className;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "address")
    private Address address;

    @ManyToOne
    private SchoolClass schoolClass;

    @Column(nullable = false, length = 127)
    @Basic(fetch = FetchType.LAZY)
    private String firstname;
    @Column(nullable = false, length = 127)
    private String lastname;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
//    @Transient
//    private String fullname;

    public String getFullname() {
        return String.format("%s %s", lastname, firstname);
    }

    public Student(@NonNull long catNo, @NonNull String className, String firstname, String lastname, LocalDate dateOfBirth) {
        this.catNo = catNo;
        this.className = className;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    //    public Student() {
//        studentId = UUID.randomUUID().toString();
//    }
}
