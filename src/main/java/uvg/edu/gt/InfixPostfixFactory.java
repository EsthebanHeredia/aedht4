package uvg.edu.gt;

public class InfixPostfixFactory {

    public static InfixtoPosfix getConverter(String stackType) {
        IStack<Character> stack = createStack(stackType);
        return new InfixtoPosfix(stack);
    }

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