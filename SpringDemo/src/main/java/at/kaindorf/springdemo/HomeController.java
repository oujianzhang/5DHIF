package at.kaindorf.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

// Unter resources template die homepage
// Rest Controller gibt serialized werte zurück
// Controller redirect to HTML Datei
@Controller
@RequestMapping
public class HomeController implements Serializable {

    @GetMapping()
    public String home() {
        return "homepage";
    }

}
