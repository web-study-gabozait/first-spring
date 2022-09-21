package studySpring2022.studySpring2022.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hello")
public class Hello {

    private Person person;

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }

    public void sayHello () {
        System.out.printf("Hello %s\n", (person != null ? person.getName() : "Someone"));
    }
}
