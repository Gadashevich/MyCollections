package structure.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    private SingleLinkedList<String> list;


    @BeforeEach
    void init(){
        list = new SingleLinkedList<>();
    }

    void addListElement(){
        list.add("Alpha");
        list.add("Beta");
        list.add("Gamma");
    }

    @Test
    void add() {
        addListElement();

        assertEquals(3, list.size());
        assertEquals("Alpha", list.get(0));
        assertEquals("Beta", list.get(1));
        assertEquals("Gamma", list.get(2));
    }

    @Test
    @DisplayName("Проверка добавления элемента по индексу")
    void addIndex() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("Alpha");
        list.add("Gamma");
        list.add(1, "Beta");

        assertEquals(3, list.size());
        assertEquals("Beta", list.get(1));
    }

    //test{Method}_Should{Do}_When{Condition}
    @Test
    void testAdd_ShouldException_WhenListIsEmpty() {
        //Проверить что мы получим IllegalArgumentException когда в пустой лист сделали вставку по несуществующему индексу
        SingleLinkedList<String> list = new SingleLinkedList<>();
        try {
            list.add(-1, "Beta");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }

    }

    @Test
    void testAdd_ShouldException_WhenListIsEmpty2() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        assertThrows(IllegalArgumentException.class, ()->list.add(-1,"Beta"));
    }

    @Test
    void removeOneElementInMid(){
        addListElement();
        list.remove(1);
        assertEquals(2,list.size());
        assertEquals("Alpha",list.get(0));
        assertEquals("Gamma",list.get(1));
    }

    @Test
    void  removeOneElement(){
        list.add("Alpha");
        list.remove(0);
        assertEquals(0,list.size());

        addListElement();

        assertEquals("Alpha",list.get(0));
        assertEquals("Beta",list.get(1));
        assertEquals("Gamma",list.get(2));
    }

    @Test
    void removeTwoElement(){
        list.add("Alpha");
        list.add("Beta");

        list.remove(0);

        assertEquals(1,list.size());
        assertEquals("Beta",list.get(0));
    }

    @Test
    void removeTwoElementIs2(){
        list.add("Alpha");
        list.add("Beta");

        list.remove(1);

        assertEquals(1,list.size());
        assertEquals("Alpha",list.get(0));
    }

    @Test
    void removeTwoElementIs3(){
       addListElement();
        list.remove(0);

        assertEquals(2,list.size());
        assertEquals("Beta",list.get(0));
        assertEquals("Gamma",list.get(1));
    }

    @Test
    void removeLastElement(){
        addListElement();
        list.remove(list.size()-1);

        assertEquals(2,list.size());
        assertEquals("Alpha",list.get(0));
        assertEquals("Beta",list.get(1));
    }


}