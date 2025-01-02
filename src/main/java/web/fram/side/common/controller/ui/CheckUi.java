package web.fram.side.common.controller.ui;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckUi {

    @GetMapping("/health")
    public String checkHealth(final Model model) {
        model.addAttribute("message", "Health Check");
        model.addAttribute("serverTime", "Server time: " + LocalDateTime.now());
        return "check/health";
    }
}
