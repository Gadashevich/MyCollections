package structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<String> stringStack;

    @BeforeEach
    void init() {
        stringStack = new Stack<>();
    }

    void fillStack() {
        stringStack.push("its_First_StringElement");
        stringStack.push("its+Second_StringElement");
        stringStack.push("it_Third_StringElement");
        stringStack.push("its`Four_StringElement");
    }

    @Test
    void push() {
        fillStack();
        assertEquals(4, stringStack.size());
        assertEquals("its`Four_StringElement", stringStack.pop());
        assertEquals("it_Third_StringElement", stringStack.pop());
        assertEquals(2, stringStack.size());
    }

    @Test
    void pushNullMessage() {
        try {
            stringStack.push(null);
            fail("no Exeption");
        } catch (IllegalArgumentException e) {
            assertEquals("Element can not be null", e.getMessage());
        }
    }

    @Test
    void pushNullException() {
        assertThrows(IllegalArgumentException.class, () -> stringStack.push(null));
    }

    @Test
    void peek() {
        fillStack();
        assertEquals(4, stringStack.size());
        assertEquals("its`Four_StringElement", stringStack.peek());
        assertEquals(4, stringStack.size());
    }

    @Test
    void peekNull() {

        assertNull(stringStack.peek());
    }

    @Test
    void pop() {
        assertNull(stringStack.pop());
        assertEquals(0, stringStack.size());
    }

}