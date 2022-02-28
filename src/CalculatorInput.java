package by.training.vnemero.calculator;

import java.util.Scanner;

public class CalculatorInput {

    public static String expressionInput(){
        System.out.println("Enter your expression: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
