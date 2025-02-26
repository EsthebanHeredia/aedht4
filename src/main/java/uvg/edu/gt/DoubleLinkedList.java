package uvg.edu.gt;

/**
 * Implementación de una lista que extiende @link AbstractList, enlazada
 *
 * @param <T> Tipo de datos que almacenará 
 */
public class DoubleLinkedList<T> extends AbstractList<T> {

    /**
     * Clase interna que representa un nodo en la lista doblemente enlazada
     */
    private class Node {
        T data;
        Node next;
        Node prev;

        /**
         * Constructor de un nodo con el dato especificado
         *
         * @param data Dato almacenado en el nodo
         */
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructor que inicializa la lista vacía
     */
    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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
            if (head != null) {
                head.prev = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
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
