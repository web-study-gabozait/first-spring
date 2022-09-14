package studySpring2022.studySpring2022;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Configuration1 {

    @Bean
    public Hello hello() {
        System.out.println("hello() 가 호출된");
        Hello hello = new Hello();
        hello.setPerson(mary());

        return hello;
    }

    @Bean
    public Person smith() {
        Person person = new Person();
        person.setName("Mr.smith");

        return person;
    }

    @Bean
    public Person mary() {
        Person person = new Person();
        person.setName("Mr.mary");

        return person;
    }
}
