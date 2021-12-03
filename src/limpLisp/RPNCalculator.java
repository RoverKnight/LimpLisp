package limpLisp;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class RPNCalculator {

    public static void main(String[] args) {
        // TODO: check if input is correct
        // TODO: -> num of ops == num of nums - 1
        // TODO: -> there must be 2 nums in stack before op
        // TODO: -> check if dividing by 0

        // get input
        System.out.println("Enter calculation (in 1 line; separated by spaces!):");
        Scanner scanner = new Scanner(System.in);
        String rawInput = scanner.nextLine();
        String[] input = rawInput.split(" ");

        // set up for calculation
        int result = 0;
        Stack stack = new Stack();

        // parse through each data entry
        for (String data : input) {

            // if data is integer, add to stack
            try {
                int num = Integer.parseInt(data);
                stack.push(new Element("" + num));
            }

            // catch executes if String given is an operator; calculates
            catch (NumberFormatException ignored) {
                int num1 = Integer.parseInt(stack.pop().getDaten());
                int num2 = Integer.parseInt(stack.pop().getDaten());
                switch (data) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    default:
                        System.out.println("Unknown operation: \"" + data + "\"; stopping program...");
                        return;
                }

                // push result to stack
                stack.push(new Element("" + result));
            }
        }

        System.out.println("Result: " + stack.top().getDaten());




    }



}
