package examdb.api;

import examdb.database.ClassnameRepository;
import examdb.pojos.Classname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
public class ClassnameController {

    @Autowired
    private ClassnameRepository classnameRepo;


    @GetMapping("/classnames")
    List<Classname> sortedAll() {
        List<Classname> sortedClassnames = classnameRepo.findAll();
        sortedClassnames.sort(Comparator.comparing(Classname::getClassname));
        return sortedClassnames;
    }


}
