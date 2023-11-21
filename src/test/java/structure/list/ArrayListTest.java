package structure.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structure.list.ArrayList;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ArrayList<String> list;

    @BeforeEach
    void init() {
        list = new ArrayList<>();
    }

    void fillListFourStrings() {
        list.add("its_First_StringElement");
        list.add("its+Second_StringElement");
        list.add("it_Third_StringElement");
        list.add("4");
    }

    @Test
    void add() {
        fillListFourStrings();
        assertEquals(4, list.size());
        assertEquals("its_First_StringElement", list.get(0));
        assertEquals("its+Second_StringElement", list.get(1));
        assertEquals("it_Third_StringElement", list.get(2));
        assertEquals("4", list.get(3));
    }

    @Test
    void addLinerlistUserCopasity() {
        list = new ArrayList<>(2);
        fillListFourStrings();
        assertEquals("its_First_StringElement", list.get(0));
        assertEquals("its+Second_StringElement", list.get(1));
        assertEquals("it_Third_StringElement", list.get(2));
        assertEquals("4", list.get(3));
    }




    @Test
    void indexOf() {
    list = new ArrayList<>(3);
    list.add("Первый индекс");
    list.add("Второй индекс");
    list.add("Третий индекс");
    list.add(0,"Нулевой индекс");
    list.add("Четвертый индекс");
    assertEquals(0, list.indexOf("Нулевой индекс"));
    assertEquals(1, list.indexOf("Первый индекс"));
    assertEquals(2, list.indexOf("Второй индекс"));
    assertEquals(3, list.indexOf("Третий индекс"));
    assertEquals(4, list.indexOf("Четвертый индекс"));
    assertEquals(-1, list.indexOf("индекс"));
    }




    @Test
    void AddTestWithLeftShift() {  // Расширение массива и вставка в левую часть
        list = new ArrayList<>(3);
        list.add("Первый элемент");
        list.add("Второй элемент");
        list.add("Третий элемент");
        list.add(0,"Нулевой элемент");
        list.add("Четвертый элемент");
        assertEquals(5, list.size());
        assertEquals("Нулевой элемент", list.get(0));
        assertEquals("Первый элемент", list.get(1));
        assertEquals("Второй элемент", list.get(2));
        assertEquals("Третий элемент", list.get(3));
        assertEquals("Четвертый элемент", list.get(4));
    }

    @Test
    void AddTestWithLeftShift2() {  // Вставка в левую часть и расширение массива
        list = new ArrayList<>(3);
        list.add("Второй элемент");
        list.add("Третий элемент");
        list.add("Четвертый элемент");
        list.add(0,"Нулевой элемент");
        list.add(1,"Первый элемент");

        assertEquals(5, list.size());
        assertEquals("Нулевой элемент", list.get(0));
        assertEquals("Первый элемент", list.get(1));
        assertEquals("Второй элемент", list.get(2));
        assertEquals("Третий элемент", list.get(3));
        assertEquals("Четвертый элемент", list.get(4));
    }

    @Test
    void AddTestLeftShift() {  // Вставка в левую часть со сдвигом
        list = new ArrayList<>(4);
        list.add("Нулевой элемент");
        list.add("Второй элемент");
        list.add("Третий элемент");
        list.add(1,"Первый элемент");

        assertEquals(4, list.size());
        assertEquals("Нулевой элемент", list.get(0));
        assertEquals("Первый элемент", list.get(1));
        assertEquals("Второй элемент", list.get(2));
        assertEquals("Третий элемент", list.get(3));
    }

    @Test
    void AddTestRightShift() {  // Вставка в левую, сдвиг в правую часть
        list = new ArrayList<>(4);
        list.add("Первый элемент");
        list.add("Второй элемент");
        list.add(0,"Нулевой элемент");
        list.add("Третий элемент");

        assertEquals(4, list.size());
        assertEquals("Нулевой элемент", list.get(0));
        assertEquals("Первый элемент", list.get(1));
        assertEquals("Второй элемент", list.get(2));
        assertEquals("Третий элемент", list.get(3));
    }


    @Test
    void removeLeft() {
        fillListFourStrings();
        list.remove(1);
        assertEquals(3, list.size());
        assertEquals("its_First_StringElement", list.get(0));
        assertEquals("it_Third_StringElement", list.get(1));
        assertEquals("4", list.get(2));
    }
    @Test
    void removeRight() {
        fillListFourStrings();
        list.remove(list.size()-2);
        assertEquals(3, list.size());
        assertEquals("its_First_StringElement", list.get(0));
        assertEquals("its+Second_StringElement", list.get(1));
        assertEquals("4", list.get(2));
    }

    @Test
    void remove() throws NoSuchFieldException, IllegalAccessException {
        list = new ArrayList<>(100);
        fillListFourStrings();
        list.remove(1);
        assertEquals(3, list.size());
        assertEquals("its_First_StringElement", list.get(0) );
        assertEquals("it_Third_StringElement", list.get(1));
        assertEquals("4", list.get(2));
        Field field = ArrayList.class.getDeclaredField("items");
        field.setAccessible(true);
        Object[] items = (Object[]) field.get(list);
        assertEquals(50,items.length);
    }


    @Test
    void clear() {
        fillListFourStrings();
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void sort() {
    }
}
