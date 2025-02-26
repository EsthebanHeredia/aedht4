package uvg.edu.gt;

/**
 * Implementación de una lista enlazada simple, extendiendo {@link AbstractList}.
 *
 * @param <T> Tipo de datos que almacenará la lista.
 */
public class SingleLinkedList<T> extends AbstractList<T> {

    /**
     * Clase interna que representa un nodo en la lista enlazada.
     */
    private class Node {
        T data;
        Node next;

        /**
         * Constructor de un nodo con el dato especificado.
         *
         * @param data Dato almacenado en el nodo.
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    /**
     * Constructor que inicializa la lista vacía.
     */
    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        if (index == 0) {
            head = head.next;
        } else {
            Node previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }
        size--;
        return current.data;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T element) {
        add(element);
    }

    @Override
    public T pop() {
        return remove(size - 1);
    }

    @Override
    public T peek() {
        return get(size - 1);
    }
}
