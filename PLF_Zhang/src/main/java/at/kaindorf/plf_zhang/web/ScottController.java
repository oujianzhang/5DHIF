package at.kaindorf.plf_zhang.web;

import at.kaindorf.plf_zhang.database.DepartmentRepository;
import at.kaindorf.plf_zhang.database.EmployeeRepository;
import at.kaindorf.plf_zhang.database.SalgradeRepository;
import at.kaindorf.plf_zhang.pojo.Department;
import at.kaindorf.plf_zhang.pojo.Employee;
import at.kaindorf.plf_zhang.pojo.Salgrade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/scottdb")
public class ScottController
{
  @Autowired
  private DepartmentRepository deptRepo;

  @Autowired
  private EmployeeRepository empRepo;

  @Autowired
  private SalgradeRepository salRepo;

  @ModelAttribute
  public void addAttributes(Model model)
  {
    model.addAttribute("departments", deptRepo.findAll());
    model.addAttribute("department", new Department());
    model.addAttribute("salgrades", new HashMap<Employee, Salgrade>());
    model.addAttribute("employee", new Employee());
  }

  @GetMapping()
  public String getDepartments(Model model)
  {
    log.info("get /scottdb");
    model.addAttribute("departments", deptRepo.findAll());
    return "scottView";
  }

  @PostMapping()
  public String getEmployees(Model model, @RequestParam("deptno") Integer deptno)
  {
    log.info("post /scottdb");
    deptRepo.findById(deptno).ifPresent(d -> {
      model.addAttribute("department", d);
      Map<Employee, Salgrade> s = new HashMap<>();
      d.getEmployees().forEach(e -> {
        s.put(e, salRepo.findSalgradeOfEmployee(e.getSalary()));
      });
      model.addAttribute("salgrades", s);
    });
    return "scottView";
  }

  @PostMapping("/addEmp")
  public String addEmployee(Model model, Employee emp)
  {
    log.info("post /scottdb/addEmp");
    Department dept = (Department) model.getAttribute("department");
    log.info(dept.toString());
    emp.setDeptno(dept);
    emp.setEmpNo(empRepo.getMaxId());
    empRepo.save(emp);
    return "scottView";
  }
}
