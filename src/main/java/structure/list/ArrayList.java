package structure.list;

import structure.AbstractCollection;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> extends AbstractCollection<T> implements List<T> {
    private int size;
    private Object[] items;
    private int start;


    public ArrayList() {
        items = new Object[8];
    }

    public ArrayList(int capacity) {
       if(capacity < 1 ){
           throw new IllegalArgumentException("Копасити не может быть меньше 0");
       }
       items = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override

    public void add(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Не корректный индекс");
        }
        if (size == 0) {
            items[size] = element;
        } else if (size < items.length) { //Резерв есть
            if (index <= size / 2) {  //Вставка в 1 половину
                if (start == 0) { // Резерва нет в начале
                    addLeftShift(index, element);
                } else {   //Резерв есть в начале массива
                    addLeft(index, element);
                }
            } else { // Вставка во 2 половину
                if (start + size < items.length) {  // Есть резерв в конце массива
                    addRight(index, element);
                } else { // Нет резерва
                    addRightShift(index, element);
                }
            }
        } else {  //Резерва нет, пересоздаем массив на большее кол-во элементов
            recreationItems(index, element);
        }
        size++;
    }

    private void addLeftShift(int index, T element) {
        //  int newStart = (items.length - size) / 2;
        for (int i = size - 1; i >= index; i--) {
            items[start + i +1] = items[i];
        }
        items[start + index] = element;
        for (int i = index -1 ; i >= 0; i--) {
            items[start + i] = items[i];
        }
       Arrays.fill(items, 0, start, null);
    }

    private void addLeft(int index, T element) {
        for (int i = 0; i < index; i++) {
            items[start + i - 1] = items[start + i];
        }
        start--;
        items[start + index] = element;
    }

    private void addRight(int index, T element) {
        for (int i = size; i > index; i--) {
            items[start + i] = items[start + i - 1];
        }
        items[start + index] = element;
    }

    private void addRightShift(int index, T element) {
        int newStart = start / 2;
        for (int i = 0; i < index; i++) {
            items[newStart + i] = items[start + i];
        }
        items[newStart + index] = element;
        if (newStart != start - 1) {
            for (int i = index; i < size; i++) {
                items[newStart + i + 1] = items[start + i];
            }
        }
        start = newStart;
        Arrays.fill(items, start + size, items.length, null);
    }

    private void recreationItems(int index, T element) {
        int newStart = start;

        if (newStart == 0 && index <= size / 2) {
            newStart = (items.length * 2 - size) / 2;
        }

        Object[] newItems = new Object[items.length * 2];

        for (int i = 0; i < index; i++) {
            newItems[newStart + i] = items[start + i];
        }
        newItems[newStart + index] = element;

        for (int i = index; i < size; i++) {
            newItems[newStart + i + 1] = items[start + i];
        }
        items = newItems;
        start = newStart;
    }

    @Override
    public void remove(int index) {
        if(index<0 || index>= size) {
            throw new IllegalArgumentException("Не корректный индекс");
        }
        if(items.length > size * 4){
            int newStart = start;
            if(newStart == 0) {
                newStart = (items.length / 2 - size) / 2;
            }
           Object [] newItems = new Object[items.length / 2];
            for (int i = 0; i < index; i++) {
                newItems[newStart + i] = items[start + i];
            }
            for (int i = index; i < size; i++) {
                newItems[newStart + i] = items[start + i +1];
            }
            items = newItems;
            start = newStart;

        } else {
            if(index <= size /2){
                //удаляем слева и двигаемся в лево
                for (int i = index; i > 0 ; i--) {
                    items[start+i] = items[start+i-1];
                }
                    items[start]=null;
                    start ++;
            } else {
                //удаляем справа и двигаемся в право
                for (int i = index; i < size-1 ; i++) {
                items[start+i] = items[start+i+1];
                items[size] = null;
                }
            }
        }
        size--;
    }

    @Override
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Такого индекса нет");
        }
        return (T) items[start+index];
    }

    @Override
    public void set(int index, T element) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Такого индекса нет");
        }
       items[start+index] = element;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[start + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        size = 0;
    }

}
