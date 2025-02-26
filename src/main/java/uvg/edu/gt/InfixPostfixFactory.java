package uvg.edu.gt;

/**
 * Factory para la conversión de expresiones de infix a postfix.
 */
public class InfixPostfixFactory {

    /**
     * Crea un conversor de infix a postfix basado en el tipo de pila especificado.
     *
     * @param stackType Tipo de pila a utilizar (arraylist, vector, singlelinkedlist, doublelinkedlist).
     * @return Instancia de {@link InfixtoPosfix}.
     * @throws IllegalArgumentException Si el tipo de pila no es válido.
     */
    public static InfixtoPosfix getConverter(String stackType) {
        IStack<Character> stack = createStack(stackType);
        return new InfixtoPosfix(stack);
    }

    /**
     * Crea una instancia de pila según el tipo especificado.
     *
     * @param stackType Tipo de pila a utilizar.
     * @return Instancia de {@link IStack}.
     * @throws IllegalArgumentException Si el tipo de pila no es reconocido.
     */
    private static IStack<Character> createStack(String stackType) {
        switch (stackType.toLowerCase()) {
            case "arraylist":
                return new ArrayListStack<>();
            case "vector":
                return new VectorStack<>();
            case "singlelinkedlist":
                return new LinkedListStack<>(new SingleLinkedList<>());
            case "doublelinkedlist":
                return new LinkedListStack<>(new DoubleLinkedList<>());
            default:
                throw new IllegalArgumentException("Tipo de stack no válido: " + stackType);
        }
    }
}
