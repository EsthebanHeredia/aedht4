package uvg.edu.gt;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {


    @Test
    public void testPostfixExpressionEvaluation() {
        String input = "postfix\n1\n3 4 +\narraylist\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Resultado: 7"));
    }

    @Test
    public void testInvalidExpressionType() {
        String input = "invalid\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Opción no válida. Debe ingresar 'infix' o 'postfix'."));
    }

    @Test
    public void testInvalidPostfixOption() {
        String input = "postfix\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Opción no válida."));
    }


    @Test
    public void testSingleLinkedListStack() {
        String input = "postfix\n1\n3 4 +\nlist\nsimple\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Resultado: 7"));
    }

    @Test
    public void testDoubleLinkedListStack() {
        String input = "postfix\n1\n3 4 +\nlist\ndoble\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Resultado: 7"));
    }

    @Test
    public void testExpressionFromFile() {
        String input = "postfix\n2\narraylist\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(new String[]{});

        String output = outputStream.toString();
        // This part is tricky because the expression is random; just check if it contains the expected parts
        assertTrue(output.contains("Expresión generada y guardada en datos.txt:"));
        assertTrue(output.contains("Resultado:"));
    }


    @Test
    public void testGenerarExpresionAleatoria() {
        String expresion = App.generarExpresionAleatoria();
        String[] parts = expresion.split(" ");
        assertEquals(3, parts.length);
        assertTrue(parts[2].equals("+") || parts[2].equals("*"));
    }
}