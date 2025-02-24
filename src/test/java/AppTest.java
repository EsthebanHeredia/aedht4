package uvg.edu.gt;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class AppTest {

    private CalculadoraPostfix calculadora;
    private IStack<Integer> stack;

    @TempDir
    Path tempDir;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>(100);
        calculadora = new CalculadoraPostfix(stack);
    }

    @Test
    public void testEvaluarExpresion() throws Exception {
        // Simula la entrada del usuario
        String expresion = "3 4 +";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Llama al método evaluarExpresion directamente
        App.evaluarExpresion(calculadora, expresion);

        String expectedOutput = "Resultado: 7\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testEvaluarExpresionCompleja() throws Exception {
        // Prueba una expresión más compleja
        String expresion = "5 2 4 * + 7 -";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.evaluarExpresion(calculadora, expresion);

        String expectedOutput = "Resultado: 6\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testEvaluarExpresionInvalida() throws Exception {
        // Prueba una expresión inválida (faltan operandos)
        String expresion = "5 +";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.evaluarExpresion(calculadora, expresion);

        assertTrue(outContent.toString().contains("Error: Expresión mal formateada"));
    }
    @Test
    public void testExpresionAleatoriaEvaluable() throws Exception {
        // Verifica que todas las expresiones generadas sean evaluables
        for (int i = 0; i < 5; i++) {
            File tempFile = new File(tempDir.toFile(), "eval_" + i + ".txt");
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            App.generarYEvaluarExpresionAleatoria(calculadora, tempFile.getAbsolutePath());

            // Verifica que no se produzcan errores al evaluar
            assertFalse(outContent.toString().contains("Error:"),
                    "Error al evaluar: " + Files.readString(tempFile.toPath()));
        }
    }
    private boolean isValidPostfixExpression(String expression) {
        // Patrón para verificar que la expresión tenga el formato correcto
        // Debe tener al menos dos números y un operador
        // Ejemplo válido: "3 4 +" o "5 2 4 * + 7 -"
        String regex = "^(\\d+\\s+)+(\\d+\\s+)([+\\-*/]\\s+)*[+\\-*/]$";
        return Pattern.matches(regex, expression + " ");
    }
}