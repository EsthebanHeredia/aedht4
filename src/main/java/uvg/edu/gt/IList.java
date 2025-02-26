package uvg.edu.gt;

/**
 * Interfaz que define las operaciones de una lista, extiende funciones de una pila
 *
 * @param <T> Tipo de datos que almacenará dicha lista
 */
public interface IList<T> extends IStack<T> {

    /**
     * Agrega un elemento al final de la lista
     *
     * @param element lo que se agrega
     */
    void add(T element);

    /**
     * Elimina y devuelve un elemento en una posición específica 
     *
     * @param index Índice del elemento a eliminar
     * @return Elemento lo que se elimina
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites de la lista
     */
    T remove(int index);

    /**
     * Obtiene un elemento en una posición específica de la lista sin eliminarlo
     *
     * @param index 
     * @return Elemento .
     * @throws IndexOutOfBoundsException 
     */
    T get(int index);

    /**
     * Obtiene el número de elementos en la lista
     *
     * @return Tamaño de la lista
     */
    int size();

    /**
     * Verifica si la lista está vacía.
     *
     * @return {@code true} si la lista está vacía, {@code false} en caso contrario.
     */
    boolean isEmpty();
}
