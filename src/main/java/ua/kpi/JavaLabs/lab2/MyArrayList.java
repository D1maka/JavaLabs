package ua.kpi.JavaLabs.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by dmytro_veres on 02.10.14.
 */
public class MyArrayList implements MyList {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity;
    private int size;
    private Object[] array;

    public MyArrayList() {
        size = 0;
        capacity = INITIAL_CAPACITY;
        array = new Object[capacity];
    }

    @Override
    public void add(Object o) {
        if (isLoaded()) {
            expand(this.capacity);
        }

        array[size++] = o;
    }

    @Override
    public void add(int index, Object element) {
        isInBounds(index, true);
        if (isLoaded()) {
            expand(this.capacity);
        }

        array[index] = element;
        size++;
    }

    @Override
    public void addAll(Object[] c) {
        if (size + c.length >= capacity) {
            expand(size + c.length);
        }
        Object[] newArray = Arrays.copyOf(array, this.capacity);
        System.arraycopy(c, 0, newArray, size, c.length);
        size = size + c.length;
    }

    @Override
    public void addAll(int index, Object[] c) {
        isInBounds(index, true);
        if (size + c.length >= capacity) {
            expand(size + c.length);
        }
        Object[] newArray =  Arrays.copyOf(array, this.capacity);
        System.arraycopy(array, index, newArray, array.length, array.length);
        System.arraycopy(c, 0, newArray, array.length, c.length);
        size = size + c.length;
    }

    @Override
    public Object get(int index) {
        isInBounds(index, false);
        return array[index];
    }

    @Override
    public Object remove(int index) {
        isInBounds(index, false);
        final Object deleted = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
        return deleted;
    }

    @Override
    public void set(int index, Object element) {
        array[index] = element;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private boolean isLoaded() {
        return capacity * LOAD_FACTOR >= size;
    }

    private void expand(int capacity) {
        this.capacity = capacity * 3 / 2 + 1;
        if (this.capacity < 0) {
            throw new OutOfMemoryError();
        } else {
            final Object[] newArray = Arrays.copyOf(array, this.capacity);
            array = newArray;
        }
    }

    private void isInBounds(int index, boolean includeLast) {
        if (includeLast) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
        } else {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}
