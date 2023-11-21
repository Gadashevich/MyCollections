package structure.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structure.queue.SimpleQueue;

import static org.junit.jupiter.api.Assertions.*;

class SimpleQueueTest {

    private SimpleQueue<String> stringSimpleQueue;

    @BeforeEach
    void init() {
        stringSimpleQueue = new SimpleQueue<>();
    }

    void fillQueue(){
        stringSimpleQueue.put("its_First_StringElement");
        stringSimpleQueue.put("its+Second_StringElement");
        stringSimpleQueue.put("it_Third_StringElement");
        stringSimpleQueue.put("its`Four_StringElement");
    }

    @Test
    void put() {
        fillQueue();
        assertEquals(4, stringSimpleQueue.size());
        stringSimpleQueue.put("its`FIVE_StringElement");
        assertEquals(5, stringSimpleQueue.size());
        assertEquals("its`FIVE_StringElement", stringSimpleQueue.poll());
        assertEquals(4, stringSimpleQueue.size());
    }

    @Test
    void putNullException(){
        assertThrows(IllegalArgumentException.class, () -> stringSimpleQueue.put(null));
    }

    @Test
    void  putNullMessage(){
        try{
            stringSimpleQueue.put(null);
            fail("No Exeption");
        } catch(IllegalArgumentException e) {
            assertEquals("Element can not be null", e.getMessage());
        }
    }

    @Test
    void getFirstElement() {
     fillQueue();
     assertEquals(4, stringSimpleQueue.size());
     assertEquals("its_First_StringElement", stringSimpleQueue.peek());
     assertEquals("its_First_StringElement", stringSimpleQueue.peek());
     assertEquals(4, stringSimpleQueue.size());
    }

//    @Test
//    void getLastElement() {
//        fillQueue();
//        assertEquals(4,stringQueue.size());
//        assertEquals("its`Four_StringElement",stringQueue.getLastElement());
//        assertEquals("its`Four_StringElement",stringQueue.getLastElement());
//        assertEquals(4,stringQueue.size());
//    }

    @Test
    void poll() {
        assertNull(stringSimpleQueue.poll());
        assertEquals(0, stringSimpleQueue.size());
    }



}