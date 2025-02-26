package uvg.edu.gt;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static final String FILE_NAME = "datos.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preguntar si la expresión es infix o postfix
        System.out.println("¿Qué tipo de expresión desea ingresar? (infix/postfix):");
        String tipoExpresion = scanner.nextLine().toLowerCase();

        if (!tipoExpresion.equals("infix") && !tipoExpresion.equals("postfix")) {
            System.out.println("Opción no válida. Debe ingresar 'infix' o 'postfix'.");
            return;
        }

        String expresion = "";
        boolean desdeArchivo = false;

        if (tipoExpresion.equals("postfix")) {
            System.out.println("¿Desea ingresar una expresión (1) o generar y leer desde el archivo (2)?");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            if (opcion == 1) {
                System.out.println("Ingrese la expresión postfix:");
                expresion = scanner.nextLine();
            } else if (opcion == 2) {
                expresion = generarExpresionAleatoria();
                desdeArchivo = true;  // Indica que leeremos desde el archivo
            } else {
                System.out.println("Opción no válida.");
                return;
            }
        } else {
            // Si es infix, primero pide la expresión antes de seleccionar la pila
            System.out.println("Ingrese la expresión infix:");
            expresion = scanner.nextLine();
        }

        // Selección del tipo de pila
        System.out.println("Seleccione el tipo de pila: arraylist, vector o list");
        String tipoPila = scanner.nextLine().toLowerCase();

        if (tipoPila.equals("list")) {
            System.out.println("Seleccione el tipo de lista: simple o doble");
            String tipoLista = scanner.nextLine().toLowerCase();

            if (tipoLista.equals("simple")) {
                tipoPila = "singlelinkedlist";
            } else if (tipoLista.equals("doble")) {
                tipoPila = "doublelinkedlist";
            } else {
                System.out.println("Tipo de lista no reconocido.");
                return;
            }
        }

        try {
            IStack<Integer> stack = StackFactory.createStack(tipoPila);
            CalculadoraPostfix calculator = new CalculadoraPostfix(stack);
            int resultado;

            if (tipoExpresion.equals("infix")) {
                InfixtoPosfix converter = InfixPostfixFactory.getConverter(tipoPila);
                String expresionPostfix = converter.convert(expresion);

                if (expresionPostfix.equals("Invalid Expression")) {
                    System.out.println("Error: La expresión infix ingresada no es válida.");
                    return;
                }

                resultado = calculator.evaluate(expresionPostfix);
                System.out.println("Expresión convertida a postfix: " + expresionPostfix);
            } else {
                if (desdeArchivo) {
                    guardarEnArchivo(expresion);  // Sobrescribe `datos.txt`
                    System.out.println("Expresión generada y guardada en datos.txt: " + expresion);
                }
                resultado = calculator.evaluate(expresion);
            }

            System.out.println("Resultado: " + resultado);

            // Si es postfix y se generó automáticamente, guarda también el resultado
            if (tipoExpresion.equals("postfix") && desdeArchivo) {
                guardarEnArchivo(expresion + " = " + resultado);
                System.out.println("Expresión y resultado guardados en datos.txt.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error matemático: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        scanner.close();
    }

    /**
     * Guarda una expresión en un archivo de texto.
     */
    public static void guardarEnArchivo(String contenido) {
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) { // Sobrescribe el archivo
            writer.write(contenido + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar la expresión: " + e.getMessage());
        }
    }

    /**
     * Genera una expresión postfix aleatoria (simple para prueba).
     */
    public static String generarExpresionAleatoria() {
        Random rand = new Random();
        int a = rand.nextInt(10) + 1;
        int b = rand.nextInt(10) + 1;
        String operador = rand.nextBoolean() ? "+" : "*";  // Usa + o * para simplicidad
        return a + " " + b + " " + operador;
    }
}