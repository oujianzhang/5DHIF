package at.kaindorf.plf_zhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salgrade")
public class Salgrade
{
  @Id
  @Column(name = "grade", nullable = false)
  private Integer gradeId;

  @Column(name = "losal")
  private Integer losal;

  @Column(name = "hisal")
  private Integer hisal;
}