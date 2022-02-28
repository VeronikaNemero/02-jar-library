package by.training.vnemero.calculator;

import java.util.ArrayList;
import java.util.List;

import static by.training.vnemero.calculator.CalculatorOperation.calculateWithOperation;

public class CalculatorAnalyze {

    public static double analyzeOfExpression(String expression) {
        double result = 0;

        String operation = "";

        List<Character> openBrackets = new ArrayList<Character>();
        List<Character> closeBrackets = new ArrayList<Character>();
        StringBuilder innerInput = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char inputChar = expression.charAt(i);
            if (openBrackets.isEmpty()){
                if (Character.isDigit(inputChar)) {

                    if (operation == "" && result == 0) {
                        result = Character.digit(inputChar, Character.MAX_RADIX);
                        continue;
                    } else if (operation != "") {
                        result = calculateWithOperation(operation, Character.digit(inputChar, Character.MAX_RADIX), result);
                        continue;
                    }
                }
                if (inputChar == '+' || inputChar == '-' || inputChar == '*' || inputChar == '/') {
                    operation = Character.toString(inputChar);
                    continue;
                }
            }
            if (inputChar == '(') {
                // set operation to be empty in order to calculate the
                // operations inside the brackets ..
                openBrackets.add(inputChar);
                continue;
            }
            if(inputChar ==')'){
                closeBrackets.add(inputChar);
                if(openBrackets.size() == closeBrackets.size()){
                    openBrackets.remove((Character)'(');
                    closeBrackets.remove((Character)')');
                    double evalResult =  analyzeOfExpression(innerInput.toString());
                    result = calculateWithOperation(operation,evalResult,result);
                    innerInput.setLength(0);
                }
                if(openBrackets.size()> closeBrackets.size()){
                    continue;
                }
            }
            else{
                innerInput.append(inputChar);
            }
        }
        return result;
    }
}
