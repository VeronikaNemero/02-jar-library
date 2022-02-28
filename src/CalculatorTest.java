package by.training.vnemero.calculator;

public class CalculatorTest {

    public static void main(String[] args) {
        String userValue = CalculatorInput.expressionInput();
        System.out.println(CalculatorAnalyze.analyzeOfExpression(userValue));
    }
}
