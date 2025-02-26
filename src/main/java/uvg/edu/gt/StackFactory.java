package uvg.edu.gt;

public class StackFactory {
    public static <T> IStack<T> createStack(String type) {
        System.out.println("Creando stack de tipo: " + type); // Depuración

        switch (type.toLowerCase()) {
            case "arraylist":
                return new ArrayListStack<>();
            case "vector":
                return new VectorStack<>();
            case "singlelinkedlist":
                return new LinkedListStack<>(new SingleLinkedList<>());
            case "doublelinkedlist":
                return new LinkedListStack<>(new DoubleLinkedList<>());
            default:
                throw new IllegalArgumentException("Tipo de pila no reconocido: " + type);
        }
    }
}