package structure.queue;

public interface Queue<T> {
    void put(T element);
    T peek();
    T poll();
}
