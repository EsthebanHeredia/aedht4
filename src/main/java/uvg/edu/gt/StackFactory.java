package uvg.edu.gt;

public class StackFactory {
    public static IStack<Integer> createStack(String type) {
        switch (type.toLowerCase()) {
            case "arraylist":
                return new ArrayListStack<>();
            case "vector":
                return new VectorStack<>();
            case "lista":
                return new LinkedListStack<>();
            default:
                throw new IllegalArgumentException("Tipo de pila no reconocido: " + type);
        }
    }
}