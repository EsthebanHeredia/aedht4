package uvg.edu.gt;

/**
 * Implementación de una pila (Stack) 
 *
 * @param <T> Tipo de datos que almacenar lapila
 */
public class Stack<T> implements IStack<T> {
    private T[] stack;
    private int top;
    private int capacity;

    /**
     * Constructor que inicializa la pila 
     *
     * @param capacity Tamaño máximo de pila
     */
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity];
        this.top = -1;
    }

    @Override
    public void push(T element) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
