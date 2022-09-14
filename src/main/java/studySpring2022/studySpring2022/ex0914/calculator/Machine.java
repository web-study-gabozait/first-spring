package studySpring2022.studySpring2022.ex0914.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("machine")
public class Machine {

    private Calculator calculator;

    @Autowired
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("두 정수를 입력하세요.");
        int value1 = scanner.nextInt();
        int value2 = scanner.nextInt();

        int result = calculator.calculate(value1, value2);
        System.out.printf("%d %s %d = %d\n", value1, calculator.getOperator(), value2 , result);

        scanner.close();
    }

}
