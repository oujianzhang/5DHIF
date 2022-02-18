package at.kaindorf.springdemo;

import at.kaindorf.springdemo.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/stu")
    public Student getStudent() {
        return new Student("Bart", "Simpson", 12);
    }

}
