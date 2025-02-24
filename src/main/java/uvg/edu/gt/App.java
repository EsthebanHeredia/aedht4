package uvg.edu.gt;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IStack<Integer> stack = new Stack<>(100); // Definimos capacidad 100 para la pila
        CalculadoraPostfix calculadora = new CalculadoraPostfix(stack);

        while (true) {
            System.out.println("\n--- CALCULADORA POSTFIX ---");
            System.out.println("1. Ingresar expresión manualmente");
            System.out.println("2. Generar expresión aleatoria y guardarla en datos.txt");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese la expresión en notación postfix: ");
                    String inputExpression = scanner.nextLine();
                    evaluarExpresion(calculadora, inputExpression);
                    break;
                case "2":
                    generarYEvaluarExpresionAleatoria(calculadora, "datos.txt");
                    break;
                case "3":
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Método para generar expresión postfix aleatoria, guardarla y evaluarla
    protected static void generarYEvaluarExpresionAleatoria(CalculadoraPostfix calculadora, String nombreArchivo) {
        String expresionAleatoria = generarExpresionPostfixAleatoria();

        // Guardar la expresión en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(expresionAleatoria);
            System.out.println("Expresión aleatoria generada y guardada en '" + nombreArchivo + "':");
            System.out.println(expresionAleatoria);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            return;
        }

        // Evaluar la expresión generada
        evaluarExpresion(calculadora, expresionAleatoria);
    }

    // Método para generar una expresión postfix aleatoria válida
    private static String generarExpresionPostfixAleatoria() {
        Random random = new Random();
        StringBuilder expresion = new StringBuilder();

        // Generamos una expresión postfix válida
        // Comenzamos con suficientes operandos (2-5)
        int numOperandos = random.nextInt(4) + 2; // Entre 2 y 5 operandos

        // Añadimos los operandos iniciales (siempre necesitamos al menos 2)
        for (int i = 0; i < 2; i++) {
            expresion.append(random.nextInt(10) + 1).append(" "); // Números entre 1 y 10
        }

        // Añadimos un operador para tener una expresión válida mínima
        expresion.append(obtenerOperadorAleatorio()).append(" ");

        // Ahora añadimos pares adicionales de operandos y operadores
        for (int i = 2; i < numOperandos; i++) {
            expresion.append(random.nextInt(10) + 1).append(" "); // Añadir otro operando
            expresion.append(obtenerOperadorAleatorio()).append(" "); // Añadir otro operador
        }

        return expresion.toString().trim();
    }

    // Método para obtener un operador aleatorio
    private static String obtenerOperadorAleatorio() {
        String[] operadores = {"+", "-", "*", "/"};
        Random random = new Random();
        return operadores[random.nextInt(operadores.length)];
    }

    // Método protegido para evaluación de expresiones
    protected static void evaluarExpresion(CalculadoraPostfix calculadora, String expresion) {
        try {
            int resultado = calculadora.evaluate(expresion);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}