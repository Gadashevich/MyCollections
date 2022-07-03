package structure;

public interface IQueue<T> {
    int size();
    void put(T element);
    T getFirstElement();
    T get();
}
