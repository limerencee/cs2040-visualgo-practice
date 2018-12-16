import java.util.Arrays;
import java.util.Optional;

class Applications {

    /**
    * Stack used to check if a string has proper bracket balance.
    * i.e Every opening bracket must be matched with a closing bracket in the correct order.
    * @param input The input String to be checked.
    * @return True if input has proper bracket balance, false otherwise.
    */
    static boolean checkBracketBalance(String input) {
        Stack<Character> stack = new Stack<>();
        long violations = 0;
        violations = input
            .chars()
            .mapToObj(x -> (char) x)
            .filter(x -> { //increment violations if brackets mismatch.
                if (x == '(' || x == '[' || x == '{') { //If open brackets, push to stack
                    stack.push(x);
                    return false;
                } else { //else if closed brackets, pop from stack and check if it matches
                    Optional<Character> opCh = stack.pop();
                    if (opCh.isEmpty()) { //if empty stack
                        return true;
                    } else { //otherwise, get popped open bracket
                        char ch = opCh.get();
                        if ((ch == '(' && x != ')') || //check if popped open bracket matches current closed bracket
                            (ch == '[' && x != ']') ||
                            (ch == '{' && x != '}')) {
                            return true;
                        }
                        return false;
                    }
                }
            })
            .count();
        return violations > 0 ? false : true;
    }

    /**
    * Performs calculations on the postfix-notation input String.
    * Real numbers are supported.
    * Optionally, end the input String with a '='.
    * Accepted operations include: + - * / %
    * @param input Input String in postfix notation
    * @return Results in type double to support all real numbers.
    */
    static double postfixArithmetic(String input) {
        //Split the input string into an array of operands and operations
        String[] items = input.split(" ");
        Stack<Double> stack = new Stack<>();
        for (String s : items) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%")) {
                double op1 = stack.pop().get();
                double op2 = stack.pop().get();
                if (s.equals("+")) {
                    stack.push(op2 + op1);
                } else if (s.equals("-")) {
                    stack.push(op2 - op1);
                } else if (s.equals("*")) {
                    stack.push(op2 * op1);
                } else if (s.equals("/")) {
                    stack.push(op2 / op1);
                } else if (s.equals("%")) {
                    stack.push(op2 % op1);
                }
            } else if (s.equals("=")) {
                return stack.pop().get();
            } else {
                stack.push(Double.parseDouble(s));
            }
        }
        return stack.pop().get();
    }
}
