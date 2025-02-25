package uvg.edu.gt;

public interface IList<T> extends IStack<T> {
    void add(T element);
    T remove(int index);
    T get(int index);
    int size();
    boolean isEmpty();
}