package study.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import study.spring.web.domain.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
        
    @PostMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value={"/hi", "/abcd", "dgsw.do"})
    public String hi() {
        return "hi";
    }

    @RequestMapping("/clock")
    public ModelAndView clock() {
        ModelAndView mv = new ModelAndView("clock");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년-MM월-dd일 HH:mm:ss");
        String time = dateFormat.format(new Date());
        mv.addObject("now", time);

        Person person = new Person();
        person.setName("금현호");
        person.setAge(25);

        mv.addObject("person", person);

        return mv;
    }

}
