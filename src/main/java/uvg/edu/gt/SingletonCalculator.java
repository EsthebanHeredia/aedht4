package uvg.edu.gt;

/**
 * Implementación del patrón Singleton para la calculadora postfix.
 */
public class SingletonCalculator {
    private static CalculadoraPostfix instance;

    /**
     * Constructor privado para evitar la instanciación externa.
     */
    private SingletonCalculator() {}

    /**
     * Devuelve una única instancia de la calculadora postfix. Si no existe, la crea.
     *
     * @param stack Implementación de pila a utilizar en la calculadora.
     * @return Instancia única de {@link CalculadoraPostfix}.
     */
    public static CalculadoraPostfix getInstance(IStack<Integer> stack) {
        if (instance == null) {
            instance = new CalculadoraPostfix(stack);
        }
        return instance;
    }

    /**
     * Restablece la instancia de la calculadora, permitiendo crear una nueva.
     */
    public static void reset() {
        instance = null;
    }
}
