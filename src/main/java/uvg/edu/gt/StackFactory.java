package uvg.edu.gt;

/**
 * Fábrica para la creación de diferentes implementaciones de pilas (Stack).
 */
public class StackFactory {

    /**
     * Crea una instancia de una pila basada en el tipo especificado.
     *
     * @param <T>  Tipo de datos que almacenará la pila.
     * @param type Tipo de pila a crear (arraylist, vector, singlelinkedlist, doublelinkedlist).
     * @return Instancia de una pila implementando {@link IStack}.
     * @throws IllegalArgumentException Si el tipo de pila no es reconocido.
     */
    public static <T> IStack<T> createStack(String type) {
        System.out.println("Creando stack de tipo: " + type);

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
