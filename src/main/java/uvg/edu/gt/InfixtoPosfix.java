package uvg.edu.gt;

public class InfixtoPosfix {

    private IStack<Character> stack;

    public InfixtoPosfix(IStack<Character> stack) {
        this.stack = stack;
    }

    // Method to return precedence of operators
    private int precedence(char ch) {
        switch (ch) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
            case '^' -> {
                return 3;
            }
        }
        return -1;
    }

    // Method to convert infix expression to postfix expression
    public String convert(String expression) {
        // Initializing empty String for result
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the scanned character is an operand, add it to output
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If the scanned character is an '(', push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else { // an operator is encountered
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

}