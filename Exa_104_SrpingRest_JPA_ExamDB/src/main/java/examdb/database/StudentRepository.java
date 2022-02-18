package examdb.database;

import examdb.pojos.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.classname.classId = :classId")
    List<Student> getAllStudentsByClassId(Long classId);

    @Query("SELECT s FROM Classname c INNER JOIN c.students s WHERE c.classId = :classId")
    List<Student> getAllStudentsByClassId2(Long classId);
}