package structure;

public class Queue<T> implements IQueue<T> {
    private Segment<T> firstSegment;
    private Segment<T> lastSegment;
    private int length;


    @Override
    public int size() {
        return length;
    }

    @Override
    public void put(T newElement) {
        if(newElement == null){
            throw  new IllegalArgumentException("Element can not be null");
        }
        Segment<T> newSegment = new Segment<>();
        newSegment.element = newElement;
        if(length == 0){
            firstSegment = newSegment;
        } else {
            lastSegment.nextSegment = newSegment;
        }
        lastSegment = newSegment;
        length++;
    }

    @Override
    public T getFirstElement() {
        if(firstSegment.element == null){
            return null;
        }
        return firstSegment.element ;

    }


    public T getLastElement() {
        if(lastSegment.element == null){
            return null;
        }
        return lastSegment.element ;
    }

    @Override
    public T get() {
        if(length == 0){
            return  null;
        }
        T returnElement = lastSegment.element;
        lastSegment = lastSegment.nextSegment;
        length--;
        return  returnElement ;
    }



}
