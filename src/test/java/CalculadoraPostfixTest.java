package uvg.edu.gt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraPostfixTest {

    @Test
    public void testEvaluateSimpleAddition() throws Exception {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        int result = calculator.evaluate("3 4 +");
        assertEquals(7, result);
    }

    @Test
    public void testEvaluateSimpleSubtraction() throws Exception {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        int result = calculator.evaluate("10 5 -");
        assertEquals(5, result);
    }

    @Test
    public void testEvaluateSimpleMultiplication() throws Exception {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        int result = calculator.evaluate("2 3 *");
        assertEquals(6, result);
    }

    @Test
    public void testEvaluateSimpleDivision() throws Exception {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        int result = calculator.evaluate("8 2 /");
        assertEquals(4, result);
    }

    @Test
    public void testEvaluateDivisionByZero() {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.evaluate("8 0 /");
        });
        assertEquals("División por cero", exception.getMessage());
    }

    @Test
    public void testEvaluateModulo() throws Exception {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        int result = calculator.evaluate("10 3 %");
        assertEquals(1, result);
    }

    @Test
    public void testEvaluateModuloByZero() {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.evaluate("10 0 %");
        });
        assertEquals("División por cero", exception.getMessage());
    }

    @Test
    public void testEvaluateUnknownOperator() {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("2 3 ^");
        });
        assertEquals("Operador desconocido: ^", exception.getMessage());
    }

    @Test
    public void testEvaluateMalformedExpression() {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("3 +");
        });
        assertEquals("Expresión mal formateada", exception.getMessage());
    }

    @Test
    public void testEvaluateEmptyExpression() {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("");
        });
        assertEquals("La expresión no puede estar vacía", exception.getMessage());
    }

    @Test
    public void testEvaluateNullExpression() {
        IStack<Integer> stack = new ArrayListStack<>();
        CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate(null);
        });
        assertEquals("La expresión no puede estar vacía", exception.getMessage());
    }
}