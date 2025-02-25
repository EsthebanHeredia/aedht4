package uvg.edu.gt;

public class StackFactory {
    public static <T> IStack<T> createStack(String type) {
        switch (type.toLowerCase()) {
            case "arraylist":
                return new ArrayListStack<>();
            case "vector":
                return new VectorStack<>();
            case "lista_simple":
                return new LinkedListStack<>(new SingleLinkedList<>());
            case "lista_doble":
                return new LinkedListStack<>(new DoubleLinkedList<>());
            default:
                throw new IllegalArgumentException("Tipo de pila no reconocido: " + type);
        }
    }
}