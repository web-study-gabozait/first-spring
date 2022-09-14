package studySpring2022.studySpring2022.ex0914.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        Machine machine = context.getBean("machine", Machine.class);
        machine.execute();

    }

}
