package at.kaindorf.springburger;

import at.kaindorf.springburger.pojos.Burger;
import at.kaindorf.springburger.pojos.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/orders")
public class SpringOrderController {

    @GetMapping("/current")
    public String requestOrder(Model model, @SessionAttribute Burger designBurger) {
        log.info("Your Burger " + designBurger);
        model.addAttribute("designBurger", designBurger);
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String performOrder(@ModelAttribute("order") Order order){
        log.info("Order from " + order);
        return "redirect:/design";
    }
}
