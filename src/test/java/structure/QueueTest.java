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
    void getFirstElement() {
    }

    @Test
    void getLastElement() {
    }

    @Test
    void get() {
    }
}