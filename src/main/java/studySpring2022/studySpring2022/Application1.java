package studySpring2022.studySpring2022;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application1-context.xml");

        Hello hello = context.getBean("hello", Hello.class);
        hello.sayHello();
    }
}
