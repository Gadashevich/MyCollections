package structure.queue;

import structure.AbstractCollection;

public class SimpleQueue<T> extends AbstractCollection<T> implements Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        public T element;
        public Node<T> next;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(T newElement) {
        if (newElement == null) {
            throw new IllegalArgumentException("Element can not be null");
        }
        Node<T> newNode = new Node<>();
        newNode.element = newElement;
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public T peek() {
        if (first.element == null) {
            return null;
        }
        return first.element;

    }

//    public T getLastElement() {
//        if (lastSegment.element == null) {
//            return null;
//        }
//        return lastSegment.element;
//    }

    @Override
    public T poll() {
        if (size == 0) {
            return null;
        }
        T returnElement = last.element;
        last = last.next;
        size--;
        return returnElement;
    }


}
