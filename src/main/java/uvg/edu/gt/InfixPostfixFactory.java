package uvg.edu.gt;

public class InfixPostfixFactory {

    public static InfixtoPosfix getConverter(String stackType) {
        IStack<Character> stack = createStack(stackType);
        return new InfixtoPosfix(stack);
    }

    private static IStack<Character> createStack(String stackType) {
        switch (stackType.toLowerCase()) {
            case "arrayliststack":
                return new ArrayListStack<>();
            case "vectorstack":
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