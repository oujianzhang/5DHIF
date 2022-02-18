package at.kaindorf.plf_zhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp")
public class Employee
{
  @Id
  @Column(name = "empno", nullable = false)
  private Integer empNo;

  @Column(name = "ename", length = 50)
  private String lastname;

  @Column(name = "job", length = 30)
  private String job;

  @ManyToOne
  @JoinColumn(name = "mgr")
  private Employee manager;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "hiredate")
  private LocalDate hiredate;

  @Column(name = "sal")
  private Integer salary;

  @Column(name = "comm")
  private Integer comm;

  @ManyToOne
  @JoinColumn(name = "deptno")
  private Department deptno;

  public String getNameFormatted() {
    return lastname.charAt(0) + lastname.toLowerCase().substring(1);
  }

  public String getJobFormatted() {
    return job.charAt(0) + job.toLowerCase().substring(1);
  }

  public String getSalaryFormatted() {
    return String.format("€ %d,00",salary);
  }
}