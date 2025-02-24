package uvg.edu.gt;

public class SingletonCalculator {
    private static CalculadoraPostfix instance;

    private SingletonCalculator() {}

    public static CalculadoraPostfix getInstance(IStack<Integer> stack) {
        if (instance == null) {
            instance = new CalculadoraPostfix(stack);
        }
        return instance;
    }

    public static void reset() {
        instance = null; // Permite reiniciar la instancia si es necesario
    }
}