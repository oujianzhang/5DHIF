package at.kaindorf.plf_zhang.database;

import at.kaindorf.plf_zhang.pojo.Salgrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalgradeRepository extends JpaRepository<Salgrade, Integer>
{
  @Query("SELECT s FROM Salgrade s WHERE ?1 BETWEEN s.losal AND s.hisal")
  Salgrade findSalgradeOfEmployee(Integer sal);
}