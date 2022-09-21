package study.spring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.spring.web.domain.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/now")
    public String now() {
        SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = dateFormat.format(new Date());

        return now;
    }

    @GetMapping("/person")
    public Person person(@RequestParam("code")String code, @RequestParam("age") int age) {
        Person person = new Person();
        person.setName(code);
//        person.setAge((int)System.currentTimeMillis() % 90 + 10);
        person.setAge(age);
        
        return person;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value= "name1", required = true) String name) {
        return "안녕하세요 " + name+"님";
    }

    @GetMapping("/add")
    public  String add(@RequestParam(value = "value1", defaultValue = "10") int value1, @RequestParam(value = "value2", defaultValue = "15") int value2) {
        return String.format("%d + %d = %d", value1,value2, value1 + value2);
    }


}
