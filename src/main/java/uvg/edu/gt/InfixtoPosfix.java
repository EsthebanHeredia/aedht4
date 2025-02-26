package uvg.edu.gt;

public class InfixtoPosfix {

    private IStack<Character> stack;

    public InfixtoPosfix(IStack<Character> stack) {
        this.stack = stack;
    }

    // Method to return precedence of operators
    private int precedence(char ch) {
        switch (ch) {
            case '+', '-' -> { return 1; }
            case '*', '/' -> { return 2; }
            case '^' -> { return 3; }
        }
        return -1;
    }

    // Method to convert infix expression to postfix expression
    public String convert(String expression) {
        StringBuilder result = new StringBuilder();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the scanned character is an operand (digit), build the number
            if (Character.isDigit(ch)) {
                numberBuffer.append(ch);
            } else {
                // If there's a number in the buffer, append it to result
                if (numberBuffer.length() > 0) {
                    result.append(numberBuffer).append(" ");
                    numberBuffer.setLength(0); // Clear the buffer
                }

                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                } else { // an operator is encountered
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.push(ch);
                }
            }
        }

        // If there's a number left in the buffer, append it
        if (numberBuffer.length() > 0) {
            result.append(numberBuffer).append(" ");
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }
}