package uvg.edu.gt;
import java.util.*;

/**
 * Implementación de una calculadora que evalua epresiones en postficx
 */
public class CalculadoraPostfix implements ICalculator {
    private IStack<Integer> stack;

    /**
     * Constructor que recibe pila 
     *
     * @param stack Implementación de pila 
     */
    public CalculadoraPostfix(IStack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public int evaluate(String expression) throws Exception {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("La expresión no puede estar vacía");
        }

        String[] tokens = expression.split("\\s+");
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión mal formateada");
                }
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> {
                        if (b == 0) throw new ArithmeticException("División por cero");
                        stack.push(a / b);
                    }
                    case "%" -> {
                        if (b == 0) throw new ArithmeticException("División por cero");
                        stack.push(a % b);
                    }
                    default -> throw new IllegalArgumentException("Operador desconocido: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión mal formateada");
        }

        return stack.pop();
    }

    /**
     * Verifica si una cadena representa un número
     *
     * @param str Cadena q se evalua
     * @return {@code true} si la cadena es un número, {@code false} si no
     */
    private boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
