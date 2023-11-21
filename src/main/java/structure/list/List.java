package structure.list;

public interface List<T> {
    void add(T element);
    void add(int index, T element);
    void set(int index, T element);
    void clear();
    void sort(boolean flag);
    void remove(int index);
    boolean remove(T element);
    int indexOf(T element);
    T get(int index);
}
