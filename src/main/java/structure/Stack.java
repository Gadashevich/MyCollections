package structure;


import structure.AbstractCollection;

public class Stack<T> extends AbstractCollection<T> {
    private Node<T> last;
    private  int size;

    private static class Node<T> {
        public T element;
        public Node<T> next;
    }


    @Override
    public int size() {
        return size;
    }

    public T pop() {
        if(size == 0){
            return  null;
        }
        T returnElement = last.element;
        last = last.next;
        size--;
        return  returnElement ;
    }

    public void push(T newElement) {
        if(newElement == null){
            throw  new IllegalArgumentException("Element can not be null");
        }
        Node<T> node = new Node<>();
        node.element = newElement;
        node.next = last;
        last = node;
        size++;
    }

    public T peek() {
       if(size ==0){
           return null;
       }
        return last.element;
    }


}
