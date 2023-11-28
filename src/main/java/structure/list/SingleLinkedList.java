package structure.list;

import structure.AbstractCollection;

public class SingleLinkedList<T> extends AbstractCollection<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        private T element;
        private Node<T> next;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        Node<T> node = new Node<>();
        node.element = element;
        if (index == size) {
            if (size == 0) {
                first = node;
            } else {
                last.next = node;
            }
            last = node;
            size++;
            return;
        }
        if (index == 0) {
            node.next = first;
            first = node;
            size++;
            return;
        }
        Node<T> previus = first;
        for (int i = 1; i < index; i++) {
            previus = previus.next;
        }
        node.next = previus.next;
        previus.next = node;
        size++;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.element = element;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        if (size == 1) {
            first = null;
            last = null;
            size = 0;
            return;
        }
        if (size == 2) {
            if (index == 0) {
                first = last;
            } else {
                last = first;
                first.next = null;
            }
            size--;
            return;
        }

        if (index == 0) {
            first = first.next;
            size--;
            return;
        }
        Node<T> previous = first;
        for (int i = 1; i < index; i++) {
            previous = previous.next;
        }
        previous.next = previous.next.next;
        if (index == size - 1) {
            last = previous;
        }
        size--;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.element;


    }
}
