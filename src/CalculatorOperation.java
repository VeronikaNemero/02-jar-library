package by.training.vnemero.calculator;

public class CalculatorOperation {

    public static double calculateWithOperation(String operation, double inputChar, double output) {
        switch (operation) {
            case "+":
                output = output + inputChar;
                break;

            case "-":
                output = output - inputChar;
                break;

            case "*":
                output = output * inputChar;
                break;

            case "/":
                output = output / inputChar;
                break;

            default:
                break;
        }
        return output;
    }
}
