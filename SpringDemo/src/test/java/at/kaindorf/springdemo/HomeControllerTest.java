package at.kaindorf.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;

import java.io.Serializable;

// Unter resources template die homepage
// Rest Controller gibt serialized werte zurück
// Controller redirect to HTML Datei

@WebMvcTest
public class HomeControllerTest implements Serializable {

    @GetMapping()
    public String home() {
        return "homepage";
    }

    @Autowired
    MockMvc mockMvc;

    public void testHome() throws Exception {
        mockMvc.perform(get("/home")).
                andExpect(status().isOk()).
                andExpect(view().name("homepage")).
                andExpect(content().string(containsString("Welcome to our homepage")));
    }

}
