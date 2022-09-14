package studySpring2022.studySpring2022.ex0914.calculator;

import org.springframework.stereotype.Component;

@Component("adder")
public class Adder implements Calculator {

    @Override
    public int calculate(int value1, int value2) {
        return value1 + value2;
    }

    @Override
    public String getOperator() {
        return "+";
    }
}
