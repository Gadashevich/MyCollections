package structure;



public class Stack<T> {
    private Segment<T> lastSegment;
    private  int length;

    public int size() {
        return length;
    }

    public T pop() {
        if(length == 0){
            return  null;
        }
        T returnElement = lastSegment.element;
        lastSegment = lastSegment.nextSegment;
        length--;
        return  returnElement ;
    }

    public void push(T newElement) {
        if(newElement == null){
            throw  new IllegalArgumentException("Element can not be null");
        }
        Segment<T> newSegment = new Segment<>();
        newSegment.element = newElement;
        newSegment.nextSegment = lastSegment;
        lastSegment = newSegment;
        length++;
    }

    public T peek() {
       if(length ==0){
           return null;
       }
        return lastSegment.element;
    }


}
