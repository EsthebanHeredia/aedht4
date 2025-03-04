package uvg.edu.gt;

import java.util.ArrayList;

/**
 * Implementación de una pila usando array
 *
 * @param <T> Tipo de datos que almacenará 
 */
public class ArrayListStack<T> extends AbstractStack<T> {
    private ArrayList<T> stack;

    /**
     * Constructor que inicializa la pila como una lista que está vacia
     */
    public ArrayListStack() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        stack.add(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
