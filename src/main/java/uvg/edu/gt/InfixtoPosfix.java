package uvg.edu.gt;

/**
 * Clase que convierte expresiones en notación infix a notación postfix otra vez
 */
public class InfixtoPosfix {
    private IStack<Character> stack;

    /**
     * Constructor que recibe una pila para el proceso de conversió
     *
     * @param stack Implementación de pila utilizada en la convers
     */
    public InfixtoPosfix(IStack<Character> stack) {
        this.stack = stack;
    }

    /**
     * Obtiene la precedencia de los operadores matemáticos
     *
     * @param ch Operador a evaluar
     * @return Nivel de precedencia (1 para + y -, 2 para * y /, 3 para ^).
     */
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

    /**
     * Convierte una expresión en notación infix a notación postfix
     *
     * @param expression Expresión en notación infix.
     * @return Expresión convertida a notación postfix.
     */
    public String convert(String expression) {
        StringBuilder result = new StringBuilder();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Si el carácter es un número, se acumula en el buffer de números
            if (Character.isDigit(ch)) {
                numberBuffer.append(ch);
            } else {
                // Si hay un número en el buffer, se añade al resultado
                if (numberBuffer.length() > 0) {
                    result.append(numberBuffer).append(" ");
                    numberBuffer.setLength(0); // Limpiar buffer
                }

                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.pop(); // Eliminar el '(' de la pila
                } else { // Si es un operador
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.push(ch);
                }
            }
        }

        
        if (numberBuffer.length() > 0) {
            result.append(numberBuffer).append(" ");
        }

        
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; 
            }
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }
}
