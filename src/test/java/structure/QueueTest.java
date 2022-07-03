package structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
private Queue<String> stringQueue;

    @BeforeEach
    void init() {
        stringQueue = new Queue<>();
    }

    void fillQueue(){
        stringQueue.put("its_First_StringElement");
        stringQueue.put("its+Second_StringElement");
        stringQueue.put("it_Third_StringElement");
        stringQueue.put("its`Four_StringElement");
    }



    @Test
    void put() {
        fillQueue();
        assertEquals(4,stringQueue.size());
        stringQueue.put("its`FIVE_StringElement");
        assertEquals(5,stringQueue.size());
        assertEquals("its`FIVE_StringElement",stringQueue.get());
        assertEquals(4, stringQueue.size());
    }

    @Test
    void putNullException(){
        assertThrows(IllegalArgumentException.class, () -> stringQueue.put(null));
    }

    @Test
    void  putNullMessage(){
        try{
            stringQueue.put(null);
            fail("No Exeption");
        } catch(IllegalArgumentException e) {
            assertEquals("Element can not be null", e.getMessage());
        }
    }

    @Test
    void getFirstElement() {
     fillQueue();
     assertEquals(4,stringQueue.size());
     assertEquals("its_First_StringElement",stringQueue.getFirstElement());
     assertEquals("its_First_StringElement",stringQueue.getFirstElement());
     assertEquals(4,stringQueue.size());
    }

    @Test
    void getLastElement() {
        fillQueue();
        assertEquals(4,stringQueue.size());
        assertEquals("its`Four_StringElement",stringQueue.getLastElement());
        assertEquals("its`Four_StringElement",stringQueue.getLastElement());
        assertEquals(4,stringQueue.size());
    }

    @Test
    void get() {
        assertNull(stringQueue.get());
        assertEquals(0,stringQueue.size());
    }



}