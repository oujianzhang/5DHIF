package at.kaindorf.plf_zhang.database;

import at.kaindorf.plf_zhang.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
  @Query("SELECT MAX(e.empNo)+1 FROM Employee e")
  Integer getMaxId();
}