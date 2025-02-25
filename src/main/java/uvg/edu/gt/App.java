package uvg.edu.gt;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de pila: arraylist, vector, lista");
        String stackType = scanner.nextLine();

        // Preguntar al usuario por el tipo de lista si selecciona "lista"
        if (stackType.equalsIgnoreCase("lista")) {
            System.out.println("Seleccione el tipo de lista: simple, doble");
            String listType = scanner.nextLine();
            stackType = "lista_" + listType.toLowerCase(); // Concatenar tipo de lista con 'lista_'
        }

        // Crear la pila con Factory Pattern
        IStack<Integer> stack;
        try {
            stack = StackFactory.createStack(stackType);
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Por favor, seleccione otra implementación de pila.");
            return;
        }

        // Crear la calculadora usando Singleton
        CalculadoraPostfix calculadora = SingletonCalculator.getInstance(stack);

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

    protected static void evaluarExpresion(CalculadoraPostfix calculadora, String expresion) {
        try {
            int resultado = calculadora.evaluate(expresion);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    protected static void generarYEvaluarExpresionAleatoria(CalculadoraPostfix calculadora, String nombreArchivo) {
        String expresionAleatoria = generarExpresionPostfixAleatoria();

        // Guardar la expresión en el archivo
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(nombreArchivo))) {
            writer.write(expresionAleatoria);
            System.out.println("Expresión aleatoria generada y guardada en '" + nombreArchivo + "':");
            System.out.println(expresionAleatoria);
        } catch (java.io.IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            return;
        }

        // Evaluar la expresión generada
        evaluarExpresion(calculadora, expresionAleatoria);
    }

    private static String generarExpresionPostfixAleatoria() {
        java.util.Random random = new java.util.Random();
        StringBuilder expresion = new StringBuilder();

        int numOperandos = random.nextInt(4) + 2; // Entre 2 y 5 operandos

        // Añadimos los operandos iniciales
        for (int i = 0; i < 2; i++) {
            expresion.append(random.nextInt(10) + 1).append(" ");
        }

        expresion.append(obtenerOperadorAleatorio()).append(" ");

        for (int i = 2; i < numOperandos; i++) {
            expresion.append(random.nextInt(10) + 1).append(" ");
            expresion.append(obtenerOperadorAleatorio()).append(" ");
        }

        return expresion.toString().trim();
    }

    private static String obtenerOperadorAleatorio() {
        String[] operadores = {"+", "-", "*", "/"};
        java.util.Random random = new java.util.Random();
        return operadores[random.nextInt(operadores.length)];
    }
}