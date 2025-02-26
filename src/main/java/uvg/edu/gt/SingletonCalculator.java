package uvg.edu.gt;

/**
 * Implementación del patrón Singleton para la calculador en si postfix
 */
public class SingletonCalculator {
    private static CalculadoraPostfix instance;

    /**
     * Constructor privado 
     */
    private SingletonCalculator() {}

    /**
     * Devuelve una única instancia de la calculadora postfix. Si no existe, la hace
     *
     * @param stack 
     * @return Instancia única de {@link CalculadoraPostfix
     */
    public static CalculadoraPostfix getInstance(IStack<Integer> stack) {
        if (instance == null) {
            instance = new CalculadoraPostfix(stack);
        }
        return instance;
    }

    /**
     * Restablece la instancia de la calculadora, permitiendo hacer una nueva
     */
    public static void reset() {
        instance = null;
    }
}
