package com.example.jpaintro.pojos;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "school_class")
@NoArgsConstructor
@RequiredArgsConstructor
public class SchoolClass implements Serializable {
    @Id
    @Column(length = 10, name = "school_classname")
    @NonNull
    private String schoolClassname;

    // CascadeType.ALL -> change = persist
    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("lastname desc, firstname asc")
    private List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        if(!studentList.contains(student))
            student.setSchoolClass(this);
            studentList.add(student);
    }
}
