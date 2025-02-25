package uvg.edu.gt;

public class LinkedListStack<T> extends AbstractStack<T> {
    private IList<T> list;

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