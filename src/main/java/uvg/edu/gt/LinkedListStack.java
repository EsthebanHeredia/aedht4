package uvg.edu.gt;

/**
 * Implementación de una pila (Stack) basada en una lista enlazada.
 *
 * @param <T> Tipo de datos que almacenará la pila.
 */
public class LinkedListStack<T> extends AbstractStack<T> {
    private IList<T> list;

    /**
     * Constructor que recibe una implementación de lista enlazada.
     *
     * @param list Lista utilizada como estructura base de la pila.
     */
    public LinkedListStack(IList<T> list) {
        this.list = list;
    }

    @Override
    public void push(T element) {
        list.push(element);
    }

    @Override
    public T pop() {
        return list.pop();
    }

    @Override
    public T peek() {
        return list.peek();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
