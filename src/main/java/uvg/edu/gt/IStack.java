package uvg.edu.gt;

/**
 * Interfaz que define las operaciones básicas de pila
 *
 * @param <T> Tipo de datos que almacenará la pila
 */
public interface IStack<T> {

    /**
     * Agrega un elemento a la cima de la pila
     *
     * @param element lo q se agrega
     */
    void push(T element);

    /**
     * Elimina y devuelve el elemento en la cima de la pila
     *
     * @return lo q se elimina
     */
    T pop();

    /**
     * Devuelve el elemento en la cima de la pila sin quitarlo
     *
     * @return Elemento en la cima de la pila
     */
    T peek();

    /**
     * Verifica si la pila está vacía
     *
     * @return {@code true} si la pila está vacía, {@code false} en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el número de elementos en la pila.
     *
     * @return Tamaño de la pila
     */
    int size();
}
