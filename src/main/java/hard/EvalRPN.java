package hard;

import java.util.Stack;

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.
Note that:
The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
 */
public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens = new String[]{"10"};
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        int calculated = 0;

        for (String s : tokens) {
            if (!checkOperator(s)) {
                numbers.push(Integer.parseInt(s));
                calculated = numbers.peek();
            } else {
                int second = numbers.pop(), first = numbers.pop();
                switch (s) {
                    case "+" -> calculated = first + second;
                    case "-" -> calculated = first - second;
                    case "*" -> calculated = first * second;
                    case "/" -> calculated = first / second;
                }
                numbers.push(calculated);
            }
        }

        return calculated;
    }

    private static boolean checkOperator(String s) {
        if (s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-")) {
            return true;
        }
        return false;
    }
}
