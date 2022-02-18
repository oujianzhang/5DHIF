package examdb.api;

import examdb.database.StudentRepository;
import examdb.pojos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepo;



    @GetMapping("/allStudentsFromClass/{classId}")
    List<Student> getAllStudentsFromClass (@PathVariable Long classId){
        return studentRepo.getAllStudentsByClassId(classId);
    }

}
