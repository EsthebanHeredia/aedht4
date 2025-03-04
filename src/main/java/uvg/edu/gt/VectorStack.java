package uvg.edu.gt;

import java.util.Vector;

/**
 * Implementación de una pila (Stack) usando un {@link Vector}.
 *
 * @param <T> Tipo de datos que almacenará
 */
public class VectorStack<T> extends AbstractStack<T> {
    private Vector<T> stack;

    /**
     * Constructor que inicializa la pila como un vector que esta vaciao
     */
    public VectorStack() {
        this.stack = new Vector<>();
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
        return stack.lastElement();
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
