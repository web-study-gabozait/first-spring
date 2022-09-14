package studySpring2022.studySpring2022;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import studySpring2022.studySpring2022.scan.Hello;

public class Application3 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration3.class);

        studySpring2022.studySpring2022.scan.Hello hello = context.getBean("hello", Hello.class);
        hello.sayHello();
    }

}
