package study.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sub")
public class SubController {

    @GetMapping("/page-first")
    public String sub1() {
        return "sub/page-1";
    }

}
