package uvg.edu.gt;

/**
 * Interfaz que define las operaciones de una lista, extendiendo las funcionalidades de una pila.
 *
 * @param <T> Tipo de datos que almacenará la lista.
 */
public interface IList<T> extends IStack<T> {

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param element Elemento a agregar.
     */
    void add(T element);

    /**
     * Elimina y devuelve un elemento en una posición específica de la lista.
     *
     * @param index Índice del elemento a eliminar.
     * @return Elemento eliminado.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites de la lista.
     */
    T remove(int index);

    /**
     * Obtiene un elemento en una posición específica de la lista sin eliminarlo.
     *
     * @param index Índice del elemento a obtener.
     * @return Elemento en la posición indicada.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites de la lista.
     */
    T get(int index);

    /**
     * Obtiene el número de elementos en la lista.
     *
     * @return Tamaño de la lista.
     */
    int size();

    /**
     * Verifica si la lista está vacía.
     *
     * @return {@code true} si la lista está vacía, {@code false} en caso contrario.
     */
    boolean isEmpty();
}
