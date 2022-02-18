package at.kaindorf.plf_zhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dept")
public class Department
{
  @Id
  @Column(name = "deptno", nullable = false)
  private Integer deptno;

  @Column(name = "dname", length = 50)
  private String dname;

  @Column(name = "loc", length = 50)
  private String location;

  @OneToMany(mappedBy = "deptno", cascade = CascadeType.ALL)
  private List<Employee> employees = new ArrayList<>();

  public String getName() {
    return dname.charAt(0) + dname.toLowerCase().substring(1) + " - " +
            location.charAt(0) + location.toLowerCase().substring(1);
  }
}